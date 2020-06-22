package com.sh.pojo;

public class Person {
    private int age;
    private String name;

    public Person( String name,int age) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }


    //公有 有参方法
    public void public_show(String str,int i)
    {
        System.out.println("public show "+str+"..."+i);
    }

    //公有 无参方法
    public void public_prin()
    {
        System.out.println("public prin");
    }


    //私有 有参方法
    private void private_show(String str,int i)
    {
        System.out.println("private show "+str+"..."+i);
    }

    //私有 无参方法
    private void private_prin()
    {
        System.out.println("private prin");
    }
}
