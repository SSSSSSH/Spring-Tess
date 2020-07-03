package com.sh.fanshe;

import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Helper {


    public static List<Method> getAllInterfaceMethods(Object o) {
        return getAllInterfaceMethods(o.getClass(), AopUtils.isCglibProxy(o));
    }

    public static List<Method> getAllInterfaceMethods(Class<?> clazz, boolean isCglibProxy) {
        Class<?>[] interfaces = null;
        if (clazz.isInterface()) {
            interfaces = new Class[]{clazz};
        } else if (isCglibProxy) {
            interfaces = clazz.getSuperclass().getInterfaces();
        } else {
            interfaces = clazz.getInterfaces();
        }

        List<Method> methodList = new ArrayList();
        Class[] var4 = interfaces;
        int var5 = interfaces.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Class<?> inter = var4[var6];
            Method[] methods = inter.getMethods();
            Method[] var9 = methods;
            int var10 = methods.length;

            for(int var11 = 0; var11 < var10; ++var11) {
                Method method = var9[var11];
                methodList.add(method);
            }
        }
        return methodList;
    }

}
