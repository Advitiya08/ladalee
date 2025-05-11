package com.ladalee.ladalee.exception;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class CustomAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.err.println(" Exception in async method: " + method.getName());
        System.err.println("Message: " + ex.getMessage());
        
        ex.printStackTrace();
    }
}

