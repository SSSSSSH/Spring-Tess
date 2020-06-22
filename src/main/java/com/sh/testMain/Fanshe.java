package com.sh.testMain;

import com.sh.pojo.User;

import java.lang.reflect.Method;

public class Fanshe {

    public static void main(String[] args) throws Exception{

        //��ȡ�ֽ����ļ��� ���� ��ȡ���乫�з���

        String classname = "com.sh.pojo.Person";
        //Ѱ�����Ƶ����ļ������ؽ��ڴ� ����class����
        Class cl = Class.forName(classname);

        //��ȡһ��Person����
        System.out.println("��ȡһ��Person����:");
        Object obj=cl.newInstance();
        System.out.println(obj);


        //1.��ȡ ���� �޲η��� public void demo2.Person.public_prin()
        Method Person_public_prin=cl.getMethod("public_prin",null);
        System.out.println("��ȡִ�� public void demo2.Person.public_prin() :");
        Person_public_prin.invoke(obj,null);

        System.out.println();

        //2.��ȡ ���� �вη��� public void demo2.Person.public_show(java.lang.String,int)
        Method Person_public_show=cl.getMethod("public_show",String.class,int.class);
        System.out.println("��ȡִ�� public void demo2.Person.public_show(java.lang.String,int) :");
        Person_public_show.invoke(obj,"�������",12);

        System.out.println();

        //3.��ȡ ˽�� �޲η��� private void demo2.Person.private_prin()
        Method Person_private_prin=cl.getDeclaredMethod("private_prin",null);
        Person_private_prin.setAccessible(true);
        System.out.println("��ȡִ�� private void demo2.Person.private_prin() :");
        Person_private_prin.invoke(obj,null);

        System.out.println();

        //4.��ȡ ˽�� �вη��� private void demo2.Person.private_show(java.lang.String,int)
        Method Person_private_show=cl.getDeclaredMethod("private_show",String.class,int.class);
        Person_private_show.setAccessible(true);
        System.out.println("��ȡִ�� private void demo2.Person.private_show(java.lang.String,int) :");
        Person_private_show.invoke(obj,"�����˽��",23);

        System.out.println();


    }

}
