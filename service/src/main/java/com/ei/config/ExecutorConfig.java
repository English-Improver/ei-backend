package com.ei.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池配置
 * @author: songyitian
 *
 */
@Configuration
public class ExecutorConfig {

   @Bean("dataCollectTask")
   public Executor dataCollectExecutor() {
       ThreadPoolTaskExecutor dataCollectTask = new ThreadPoolTaskExecutor();
       // 设置核心线程数：线程池中维护的最小线程数量
       dataCollectTask.setCorePoolSize(200);
       // 线程池中允许的最大线程数
       dataCollectTask.setMaxPoolSize(1000);
       // 任务队列容量：等待执行的任务队列的容量
       dataCollectTask.setQueueCapacity(500);
       // 线程前缀，区分任务
       dataCollectTask.setThreadNamePrefix("data-collect");
       // 超过核心线程数的线程的存活时间
       dataCollectTask.setKeepAliveSeconds(50);
       // 线程池的拒绝策略
       dataCollectTask.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

       dataCollectTask.initialize();
       return dataCollectTask;
   }
}
