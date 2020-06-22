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
        // ��ʱʱ��
        Long begin = System.currentTimeMillis();
        // sqlǰ׺
        String prefix = "INSERT INTO tb_big_data (count, create_time, random) VALUES ";
        try {
            // ����sql��׺
            StringBuffer suffix = new StringBuffer();
            // ��������Ϊ���Զ��ύ
            Connection conn = null;
            conn.setAutoCommit(false);
            // Statement st = conn.createStatement();
            // ����st��pst�����Щ
            PreparedStatement pst = conn.prepareStatement("");
            // ���ѭ�������ύ�������


            for (int i = 1; i <= 100; i++) {
                // �ڴ��ύ����
                for (int j = 1; j <= 10000; j++) {
                    // ����sql��׺
                    suffix.append("(" + j * i + ", SYSDATE(), " + i * j
                            * Math.random() + "),");
                }
                // ��������sql
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // ���ִ��sql
                pst.addBatch(sql);
                // ִ�в���
                pst.executeBatch();
                // �ύ����
                conn.commit();
                // �����һ����ӵ�����
                suffix = new StringBuffer();
            }
            // ͷ������
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ����ʱ��
        Long end = System.currentTimeMillis();
        // ��ʱ
        System.out.println("cast : " + (end - begin) / 1000 + " ms");
    }







}
