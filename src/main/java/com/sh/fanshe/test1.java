package com.sh.fanshe;

import com.sh.pojo.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class test1 {


    public static void main(String[] args) throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("setName","sh");
        Object obj=Node.class.newInstance();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            Method method = Node.class.getDeclaredMethod(entry.getKey(),String.class);
            method.invoke(obj,entry.getValue());
        }
        Node node = (Node) obj;
        System.out.println(node.getName());

        Method[] methods = Node.class.getDeclaredMethods();
        int h = methods.length;
        for (int i = 0;i<h;i++){
            Method method = methods[i];
            System.out.println(method.getName());
        }


        Class<?> clazz =String.class;

        //Class的名称（包含包路径）
        String name = clazz.getName();
        //Class的名称（不包含包路径）
        String simpleName = clazz.getSimpleName();
        //Class的父类
        Class<?> superclass = clazz.getSuperclass();
        //Class的所有public方法 包含父类的
        Method[] methodss = clazz.getMethods();
        //Class的所有本身声明的方法，不限访问权限
        Method[] declaredMethods = clazz.getDeclaredMethods();
        //Class的所有public构造方法 包含父类的
        Constructor<?>[] constructors = clazz.getConstructors();
        //Class的所有本身声明的构造方法，不限访问权限
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        //Class的所有public属性 包含父类的
        Field[] fields = clazz.getFields();
        //Class的所有本身声明的属性，不限访问权限
        Field[] declaredFields = clazz.getDeclaredFields();
        //Class实现的接口数组
        Class<?>[] interfaces = clazz.getInterfaces();
        //Class是否为接口
        boolean interface1 = clazz.isInterface();


    }
}
