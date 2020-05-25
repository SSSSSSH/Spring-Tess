package com.sh.testMain;

import com.sh.service.AbstractClass;
import com.sh.serviceImpl.Abstract1Service;
import com.sh.serviceImpl.Abstract2Service;

public class abstractMain {



    public static void main(String[] strings){
        AbstractClass abstractClass = new Abstract2Service();
        abstractClass.Work("1");
    }


}
