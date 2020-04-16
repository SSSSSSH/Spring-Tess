package com.sh;


import java.io.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.sh.pojo.Equip;
import com.sh.pojo.User;
import com.sh.service.InitListenerTest;
import com.sh.utils.Excel;
import com.sh.utils.InitListener;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;


public class main {


    @Autowired
    InitListener initListener;
    @Autowired
    InitListenerTest initListenerTest;

    public static void main(String[] args) throws Exception{


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = null;



        List<List<String>> data0 = new ArrayList<List<String>>();
        List<String> tmpMarginList = new ArrayList<>();
        tmpMarginList.add("11");
        tmpMarginList.add("12");
        tmpMarginList.add("13");
        tmpMarginList.add("14");
        tmpMarginList.add("15");
        tmpMarginList.add("16");
        tmpMarginList.add("17");
        tmpMarginList.add("18");
        tmpMarginList.add("19");
        data0.add(tmpMarginList);


        List<List<String>> data1 = new ArrayList<List<String>>();
        List<String> tmpfeeList = new ArrayList<>();
        tmpfeeList.add("22");
        tmpfeeList.add("23");
        tmpfeeList.add("24");
        tmpfeeList.add("25");
        tmpfeeList.add("26");
        tmpfeeList.add("27");
        tmpfeeList.add("28");
        tmpfeeList.add("29");
        tmpfeeList.add("30");
        tmpfeeList.add("31");
        tmpfeeList.add("32");
        tmpfeeList.add("33");
        tmpfeeList.add("34");
        data1.add(tmpfeeList);





        String[] headers0 = {"账号ID","账号名称","交易所代码","品种/合约代码","投保标志","多头按金额","多头按手数","空头按金额","空头按手数"};
        String[] headers1 = {"账号ID","账号名称","交易所代码","是否为期权","品种/合约代码","开仓按金额","开仓按手数","平仓按金额","平仓按手数","平今按金额","平今按手数","行权按金额","行权按手数"};

        XSSFWorkbook workbook = new XSSFWorkbook();

        Excel.exportExcel(workbook,0,"保证金率数据",headers0,data0,"账户保证金率数据",8,out);
        Excel.exportExcel(workbook,1,"手续费率数据",headers1,data1,"账户手续费率数据",12,out);

        workbook.write(out);
        byte[] content = out.toByteArray();
        in = new ByteArrayInputStream(content);
        out.close();


        int index;
        byte[] bytes = new byte[1024];
        FileOutputStream downloadFile = new FileOutputStream("测试.xlsx");
        while ((index = in.read(bytes)) != -1) {
            downloadFile.write(bytes, 0, index);
            downloadFile.flush();
        }
        in.close();
        downloadFile.close();


    }

    /**
     * 增强for测试
     * @param userList
     */
    private static void testForeach(List<User> userList) {
        for (User user : userList) {
            user.hashCode();
        }
    }


    /**
     * 初始化测试集合
     * @param size
     * @return
     */
    private static List<User> initList(int size) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            userList.add(new User("user" + i, String.valueOf(i)));
        }
        return userList;
    }

    //找出两个list的不同元素
    private static List<String> getDiffrent4(List<String> list1, List<String> list2) {
        List<String> diff = new ArrayList<String>();
        long start = System.currentTimeMillis();
        Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
        List<String> maxList = list1;
        List<String> minList = list2;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        }
        for (String string : maxList) {
            map.put(string, 1);
        }
        for (String string : minList) {
            Integer count = map.get(string);
            if (count != null) {
                map.put(string, ++count);
                continue;
            }
            map.put(string, 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diff.add(entry.getKey());
            }
        }
        System.out.println("方法4 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
        return diff;

    }


    //排序
    public void test(List<Equip> equipList){
        Collections.sort(equipList, new Comparator<Equip>() {
            public int compare(Equip arg0, Equip arg1) {
                String hits0 = arg0.getGrade();
                String hits1 = arg1.getGrade();
                if (hits1.compareTo(hits0) < 0) {
                    return -1;
                } else if (hits1.compareTo(hits0) == 0) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }


    public void date(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");//格式化输出日期
        Date now = new Date();
        long time = 60*1000*60*24;//60秒
        Date afterDate = new Date(now .getTime() + time);//60秒后的时间
        Date beforeDate = new Date(now .getTime() - time);//60秒前的时间
        System.out.println(sdf.format(afterDate));
        System.out.println(sdf.format(beforeDate));
        long a = afterDate.getTime()-beforeDate.getTime();
        long b= a/(60*1000);
        System.out.println(b);
    }

}


