package com.sh.springTest.impl;

import com.sh.springTest.service.MessageService;

public class MessageServiceImpl implements MessageService {

    @Override
    public String getMessage(){
        return "ssh";
    }
}
