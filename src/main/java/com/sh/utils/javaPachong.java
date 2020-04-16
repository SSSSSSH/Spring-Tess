package com.sh.utils;



/**
 * 读取网上的数据，并进行分析
 * suhang   2020-03-28  18：00
 */
import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class javaPachong {


        public static void main(String args[]){
            //网址
            String strurl="http://www.dce.com.cn/publicweb/notificationtips/exportMarginComboPerfParaData.html?exportFlag1=txt";
            //  http://www.dce.com.cn/publicweb/notificationtips/exportMarginComboPerfParaData.html?exportFlag1=txt
            try {
                URL url=new URL(strurl);
                //通过url建立与网页的连接
                URLConnection conn=url.openConnection();
                //通过链接取得网页返回的数据
                InputStream is=conn.getInputStream();
                //进行转换时，需要处理编码格式问题
                BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                //按行读取
                String line=null;
                String comboIns = "";
                String priority = "";
                String hedgeflag = "";
                String hedgeflag1 = "";
                String hedgeflag2 = "";
                String instrumentId1 = "";
                String instrumentId2 = "";
                String exchId = "";
                String directionLeg1 = "";
                String directionLeg2 = "";
                int i = 0;
                while((line=br.readLine())!=null){
                    String[] str = line.split("\t");
                    List<String> list = new ArrayList<>();
                    List<String> list1=Arrays.asList(str);
                    List<String> arrList = new ArrayList<String>(list1);
                    for (String str1:arrList){
                        if (!str1.equals("")){
                            list.add(str1);
                        }
                    }  // - 代表着卖
                    i++;
                    if ( i>3 && i<100){
                        //System.out.println(list);
                        comboIns = list.get(1);
                        priority = list.get(3);
                        hedgeflag = list.get(5);
                        String[] comboInseg =comboIns.split(",");
                        String[] hedgeflags = hedgeflag.split("-");
                        hedgeflag1= changeHedgeflag(hedgeflags[0]);
                        hedgeflag2= changeHedgeflag(hedgeflags[1]);
                        instrumentId1 = comboInseg[0];
                        instrumentId2 = comboInseg[1];
                        directionLeg1 =getBuyAndSell(instrumentId1);
                        directionLeg2 =getBuyAndSell(instrumentId2);

                        System.out.println(priority +"------"+directionLeg1+"  "+directionLeg2+ "   "+instrumentId1+"   "+instrumentId2);
                    }
                }

                br.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    private static String changeHedgeflag(String hedgeflag){
        String str = "";
        if (hedgeflag.equals("投机")){
            str = "1";
        }else
        if (hedgeflag.equals("套利")){
            str = "2";
        }else
        if (hedgeflag.equals("套保")){
            str = "3";
        }
        return str;
    }

    private static String getBuyAndSell(String ins){
        String direction = "";
        if (ins.substring(0,1).equals("-")){
            direction = "1";
            ins = ins.substring(1,ins.length());
        }else{
            direction = "0";
        }
        return direction;
    }

}
