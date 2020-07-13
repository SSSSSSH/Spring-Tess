package com.sh.testMain;

import com.sh.service.AbstractClass;
import com.sh.service.XianchengchiService;
import com.sh.serviceImpl.Abstract1Service;
import com.sh.serviceImpl.Abstract2Service;
import com.sh.serviceImpl.XianchengchiServiceImpl;

public class abstractMain {



    public static void main(String[] strings) throws  Exception{
        XianchengchiService xianchengchiService = new XianchengchiServiceImpl();
        xianchengchiService.test();
    }


}
