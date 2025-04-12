package com.ladalee.ladalee.service;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestService {
    private final long timestamp = System.currentTimeMillis();

    

    public RequestService() {
        System.out.println("new Request bean");
    }



    public String getRequestTimestamp() {
        return "Request timestamp: " + timestamp;
    }
}
