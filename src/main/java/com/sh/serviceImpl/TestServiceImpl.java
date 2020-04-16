package com.sh.serviceImpl;

import com.sh.pojo.Equip;
import com.sh.service.TestService;
import com.sh.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestServiceImpl implements TestService {

    @Override
    public String getTest(String str){
        String sql = "select name from test where id = " +"'" + str+"'";
        Connection conn = JdbcUtils.getConn();
        Statement stmt=null;
        ResultSet ret = null;
        String password=null;
        try {
            stmt = conn.createStatement();
            //执行语句，得到结果集  
            ret = stmt.executeQuery(sql);
            while (ret.next()) {
                //这里只查询的密码
                password = ret.getString(1);
            }
            ret.close();
            conn.close();//关闭连接  
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return password;
    }


    //对象属性排序
    public List<Equip> a(List<Equip> equipList){
        Collections.sort(equipList, new Comparator<Equip>() {
            public int compare(Equip arg0, Equip arg1) {
                String hits0 = arg0.getGrade();
                String hits1 = arg1.getGrade();
                if (hits1.compareTo(hits0) > 0 ) {
                    return 1;
                } else if (hits1 == hits0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return equipList;
    }


}
