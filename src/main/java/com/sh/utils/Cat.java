package com.sh.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat {
    public static void main(String[] args)
    {
        String str = "asdf_{asd}_fas_{dfa}_sdfasdf_{dfa}_ ";
        String reg = "_\\{((?:(?!\\}_)[\\s\\S])*)\\}_";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find())
        {
            System.out.println(matcher.group(1));
        }
    }
}
