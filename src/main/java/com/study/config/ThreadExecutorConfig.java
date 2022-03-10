package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

/**
 * @project: fssc-service-image
 * @ClassName: ThreadExecutorConfig
 * @author: Qin Wei Chang
 * @creat: 2022/3/10 3:43 下午
 * 描述:定义线程池
 */
@Component
@EnableAsync
public class ThreadExecutorConfig {
    //核心线程数，默认为1
    private static final int corePoolSize = 10;

    // 最大线程数，默认为Integer.MAX_VALUE
    private static final int maxPoolSize = 200;

    // 队列最大长度，一般需要设置值>=notifyScheduledMainExecutor.maxNum；默认为Integer.MAX_VALUE
    private static final int queueCapacity = 10;

    @Bean
    public static Executor smartExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize); // 线程池的核心大小
        executor.setMaxPoolSize(maxPoolSize);   // 线程池的最大数量
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("smartExecutor"); //线程池的名称  可以自己定义
        executor.initialize();
        return executor;
    }
}
