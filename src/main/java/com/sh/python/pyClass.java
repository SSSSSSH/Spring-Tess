package com.sh.python;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


public class pyClass {

    private static final Logger logger = LoggerFactory.getLogger(pyClass.class);
    public static void main(String[] strings) {


        String strurl = "https://www.huilv.cc/renminyinhanghuilv.html";
//        String strurl = "https://www.kylc.com/bank/rmbfx/b-safe.html";
        List<String> a1 = new ArrayList<>();
        try {
            URL url = new URL(strurl);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line = "";
            while((line=br.readLine())!=null){
                if (null != line && line.contains("<div class=contbox>")){
                    int i = line.length();
                    line = line.replaceAll("<"," ").replace(">"," ").
                            replace("/"," ").replace("div"," ").replace("a","");
                    String test = line.substring(line.indexOf("USD-CNY"),line.indexOf("USD-CNY")+30);
                    String[] tmp = test.split("          ");
                    BigDecimal exchangeRate = new BigDecimal(tmp[1].replace(")","").replaceAll(" ",""));

                    System.out.println(exchangeRate);

                    for (String s : a1) {

                    }
                    System.out.println(test);
                }
            }

        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }
}
