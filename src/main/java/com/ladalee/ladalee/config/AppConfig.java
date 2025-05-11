package com.ladalee.ladalee.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import com.ladalee.ladalee.filter.AuthFilter;

import jakarta.servlet.Filter;


@Configuration
public class AppConfig  implements AsyncConfigurer{
     @Bean
    public FilterRegistrationBean<Filter> authFilterBean() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AuthFilter());
        registration.addUrlPatterns("/*"); // Apply to all endpoints
        registration.setOrder(1); // Runs before LoggingFilter
        return registration;
    }
    @Override 
    @Nullable
    public Executor getAsyncExecutor() {
        // TODO Auto-generated method stub
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5, 7, 300, null, null);
        return threadPoolExecutor;
    }

    
}
