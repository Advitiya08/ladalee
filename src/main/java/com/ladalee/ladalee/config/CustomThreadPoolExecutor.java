package com.ladalee.ladalee.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class CustomThreadPoolExecutor {
    @Configuration
    @EnableAsync
    public class AsyncConfig {
        @Bean(name = "customExecutor")
        public Executor customExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setMaxPoolSize(1000);
            executor.setCorePoolSize(10);
            executor.setAllowCoreThreadTimeOut(true);
            

            return executor;
        }
    }
}
