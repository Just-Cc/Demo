package com.example.demo.controller;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@Async
public class TaskDemo {

    private static int CURRENT_COUNT = 0;

    /**
     * 1.cron是设置定时执行的表达式，如 0 0/5 * * * ?每隔五分钟执行一次
     * 2.zone表示执行时间的时区
     * 3.fixedDelay 和fixedDelayString 表示一个固定延迟时间执行，上个任务完成后，延迟多长时间执行
     * 4.fixedRate 和fixedRateString表示一个固定频率执行，上个任务开始后，多长时间后开始执行
     * 5.initialDelay 和initialDelayString表示一个初始延迟时间，第一次被调用前延迟的时间
     */

    @Scheduled(cron = "*/5 * * * * ?")
    public void taskDemo01(){
        System.out.println("当前时间毫秒："+System.currentTimeMillis());
    }

    @Scheduled(cron = "*/10 * * * * ?")
    public void taskDemo02(){
        int i = 0;
        System.out.println("这是第"+ CURRENT_COUNT +"次调用定时任务");
        CURRENT_COUNT++;
    }
}
