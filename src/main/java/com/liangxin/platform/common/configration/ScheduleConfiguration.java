package com.liangxin.platform.common.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
@EnableScheduling
public class ScheduleConfiguration {
    @Bean
    public ScheduledExecutorService scheduledExecutorService(){
        ScheduledExecutorService mScheduledExecutorService= Executors.newScheduledThreadPool(5);
        return mScheduledExecutorService;
    }
    @Bean
    public TaskScheduler taskScheduler(){
        return new ConcurrentTaskScheduler();
    }
}
