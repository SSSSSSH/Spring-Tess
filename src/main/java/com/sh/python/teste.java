package com.sh.python;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class teste {

    public static void main(String[] a)throws Exception{

        String strurl="http://www.dce.com.cn/publicweb/notificationtips/exportMarginComboPerfParaData.html?exportFlag1=txt";

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(strurl);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        InputStream inputStream=entity.getContent();
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        System.out.println("网页内容:"+result);
    }
}
