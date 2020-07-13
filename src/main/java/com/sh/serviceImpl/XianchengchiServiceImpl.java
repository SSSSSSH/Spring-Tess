package com.sh.serviceImpl;

import com.sh.service.XianchengchiService;
import com.sh.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.util.concurrent.*;

public class XianchengchiServiceImpl implements XianchengchiService {


    private static Integer AAA= 0;

    @Override
    public void test()throws Exception{
        ExecutorService services = new ThreadPoolExecutor(5,10,50,TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(1024));
        Long start = System.currentTimeMillis();
        System.out.println(start);
        for (int i = 0;i<10;i++){
            services.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j<100;j++){
                        System.out.println(j);
                        System.out.println("开始处理线程！！！");
                        try {
                            Thread.sleep(100);
                        }catch (Exception e){
                        }
                        System.out.println("我的线程标识是：" + Thread.currentThread().getName());
                    }
                }
            });
        }

        /*for (int i = 0;i<2;i++){
            for (int j = 0;j<100;j++){
                System.out.println(j);
            }
        }*/
        services.shutdown();
        Long end = System.currentTimeMillis();
        System.out.println(end);
        System.out.println(end-start);
    }

    private void test12(){
        AAA = AAA ++;
    }



}
