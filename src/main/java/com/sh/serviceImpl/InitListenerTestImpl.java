package com.sh.serviceImpl;

import com.sh.pojo.User;
import com.sh.service.InitListenerTest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitListenerTestImpl implements InitListenerTest {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static Map<String, Object> contextMap=new HashMap<String,Object>();


    @Override
    public void contextInitialized(ServletContextEvent sce) {//获取要加载的数据方法
        try {
            /*
             *如果在获取数据时用到其他项目包中的接口，可以用如下方法
             *  WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
             *	ResourceService resourceService = (ResourceService) wac.getBean("resourceService");// 跑批接口的实现类
             *  在springMVC.XML 中加入
             *	<bean id="resourceService" class="com.test.ResourceService" />
             */
            String JsonStr = "用到的数据";

            List<User> users = new ArrayList<>();

            //将数据放到定义好的contextMap中
            contextMap.put("JsonStr", users);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
