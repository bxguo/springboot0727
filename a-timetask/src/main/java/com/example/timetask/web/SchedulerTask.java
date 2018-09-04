package com.example.timetask.web;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: bxguo
 * @time: 2018/9/4 11:34
 */
@Component
public class SchedulerTask {
    private int count = 0;

    //@Scheduled(cron = "*/5 * * * * ?")
    private void process() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("定时任务11111执行-------》"+count++);
    }
    @Scheduled(fixedDelay = 2*1000)
    private void process2(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
