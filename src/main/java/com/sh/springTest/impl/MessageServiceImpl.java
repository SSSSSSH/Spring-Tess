package com.sh.springTest.impl;

import com.sh.springTest.service.MessageService;
import java.lang.Class;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage(){
        return "ssh";
    }
}
