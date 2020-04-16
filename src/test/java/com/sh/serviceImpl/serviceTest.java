package com.sh.serviceImpl;


import com.sh.service.TestService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class serviceTest {

    @Resource
    TestService testService;

    @Test
    public void setTestService() {
       String a = "1";
       String b = testService.getTest(a);
       System.out.println(b);
    }
}
