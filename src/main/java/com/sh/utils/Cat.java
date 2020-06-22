package com.sh.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat {

        public static void insert() {
        // 开时时间
        Long begin = System.currentTimeMillis();
        // sql前缀
        String prefix = "INSERT INTO tb_big_data (count, create_time, random) VALUES ";
        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            Connection conn = null;
            conn.setAutoCommit(false);
            // Statement st = conn.createStatement();
            // 比起st，pst会更好些
            PreparedStatement pst = conn.prepareStatement("");
            // 外层循环，总提交事务次数


            for (int i = 1; i <= 100; i++) {
                // 第次提交步长
                for (int j = 1; j <= 10000; j++) {
                    // 构建sql后缀
                    suffix.append("(" + j * i + ", SYSDATE(), " + i * j
                            * Math.random() + "),");
                }
                // 构建完整sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行sql
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        // 耗时
        System.out.println("cast : " + (end - begin) / 1000 + " ms");
    }







}
