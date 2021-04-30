package com.example.demo.properties;

import com.example.demo.controller.TaskDemo2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail teatQuartzDetail(){

        return JobBuilder.newJob(TaskDemo2.class).withIdentity("taskDemo2").storeDurably().build();

    }

    @Bean
    public Trigger testQuartzTrigger(){

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule() .withIntervalInSeconds(10).repeatForever();  //设置时间周期单位秒

        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail()).withIdentity("taskDemo2").withSchedule(scheduleBuilder).build();

    }

}
