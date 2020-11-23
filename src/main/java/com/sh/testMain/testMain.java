package com.sh.testMain;

import com.sh.utils.DateUtils;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.security.KeyStore;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static ch.qos.logback.core.net.AbstractSocketAppender.DEFAULT_PORT;
import static com.sun.jndi.ldap.LdapCtx.DEFAULT_HOST;

public class testMain {

    private static final String DEFAULT_HOST     = "127.0.0.1";
    private static final int DEFAULT_PORT     = 9999;
    private static final String CLIENT_KEY_STORE_PASSWORD  = "123456";
    private static final String CLIENT_TRUST_KEY_STORE_PASSWORD = "123456";
    private SSLSocket   sslSocket;

    public static void main(String[] a){
        testMain client = new testMain();
        client.init();
        client.process();

    }
    /**
     * 通过ssl socket与服务端进行连接,并且发送一个消息
     */
    public void process() {
        if (sslSocket == null) {
            System.out.println("ERROR");
            return;
        }
        try {
            InputStream input = sslSocket.getInputStream();
            OutputStream output = sslSocket.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(input);
            BufferedOutputStream bos = new BufferedOutputStream(output);
            bos.write("Client Message".getBytes());
            bos.flush();
            byte[] buffer = new byte[20];
            bis.read(buffer);
            System.out.println(new String(buffer));
            sslSocket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void init() {
        try {
            SSLContext ctx = SSLContext.getInstance("SSL");
            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            KeyStore ks = KeyStore.getInstance("JKS");
            KeyStore tks = KeyStore.getInstance("JKS");
            ks.load(new FileInputStream("D://Spring-Test/kclient.keystore"), CLIENT_KEY_STORE_PASSWORD.toCharArray());
            tks.load(new FileInputStream("D://Spring-Test/tclient.keystore"), CLIENT_TRUST_KEY_STORE_PASSWORD.toCharArray());
            kmf.init(ks, CLIENT_KEY_STORE_PASSWORD.toCharArray());
            tmf.init(tks);
            ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
            sslSocket = (SSLSocket) ctx.getSocketFactory().createSocket(DEFAULT_HOST, DEFAULT_PORT);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
