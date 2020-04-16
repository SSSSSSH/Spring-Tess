package com.sh.utils;

import com.sh.pojo.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class InitListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static List<User> contextMap=new ArrayList<>();

    public void init() throws ServletException {

//    logger.info("====初始化方法运行初完毕====");

    }


    public void contextInitialized(ServletContextEvent sce) {//获取要加载的数据方法
        try {
            /*
             *如果在获取数据时用到其他项目包中的接口，可以用如下方法
             *  WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
             *	ResourceService resourceService = (ResourceService) wac.getBean("resourceService");// 跑批接口的实现类
             *  在springMVC.XML 中加入
             *	<bean id="resourceService" class="com.test.ResourceService" />
             */
            User user = new User("1","suhang");

            //将数据放到定义好的contextMap中
            contextMap.add(user);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
