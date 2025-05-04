package com.ladalee.ladalee.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ladalee.ladalee.filter.AuthFilter;

import jakarta.servlet.Filter;


@Configuration
public class AppConfig {
     @Bean
    public FilterRegistrationBean<Filter> authFilterBean() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AuthFilter());
        registration.addUrlPatterns("/*"); // Apply to all endpoints
        registration.setOrder(1); // Runs before LoggingFilter
        return registration;
    }
}
