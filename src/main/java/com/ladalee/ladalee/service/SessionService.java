package com.ladalee.ladalee.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionService {
    private int counter = 0;

    

    public SessionService() {
        System.out.println("creating session service");
    }

    public String sessionCounter() {
        counter++;
        return "Session counter: " + counter;
    }
}
