package com.sh.utils;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


/**
 *
 * 读取配置中的cron
 *
 */
@Component
@EnableScheduling
public class ScheduleJob implements SchedulingConfigurer {


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //创建一个线程池调度器，默认是单线程执行
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);
        scheduledTaskRegistrar.setScheduler(executorService);

        //增加任务
        scheduledTaskRegistrar.addTriggerTask(new Task("test1"),new Trig("cronExpess1"));
        scheduledTaskRegistrar.addTriggerTask(new Task("test2"),new Trig("cronExpess2"));
        scheduledTaskRegistrar.addTriggerTask(new Task("test3"),new Trig("cronExpess2"));
    }
}

/**
 * 业务类
 */
class Task implements Runnable{
    String task;
    public Task(String task){
        this.task = task;
    }

    //具体业务
    @Override
    public void run() {
        System.out.println(task+":"+LocalDateTime.now()+","+Thread.currentThread().getName());
    }
}

/**
 * 调度类
 */
class Trig implements Trigger {

    private String cronExpress;
    public Trig(String cronExpress){
        this.cronExpress = cronExpress;
    }

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        String cron = null;
        try {
            //每次调度时加载cron表达式
            cron = new Config().getCrons().get(cronExpress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CronTrigger cronTrigger = new CronTrigger(cron);
        return cronTrigger.nextExecutionTime(triggerContext);
    }
}

/**
 * 加载cron表达式
 */
class Config{
    private static Map<String,String> cronMap;
    private static long preModifyTime;
    private String cronFile = "config/application.properties";

    public Map<String,String> getCrons() throws IOException {
        File file = new File(cronFile);
        long nowModifyTime = file.lastModified();
        if (cronMap != null && nowModifyTime == preModifyTime){
            return cronMap;
        }else {
            cronMap = new HashMap<>();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null){
                String[] s = line.split("=");
                cronMap.put(s[0].trim(),s[1].trim());
            }
            preModifyTime = nowModifyTime;
            return cronMap;
        }
    }

}

