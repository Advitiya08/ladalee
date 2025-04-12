package com.ladalee.ladalee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladalee.ladalee.service.RequestService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public ResponseEntity<String> requestEndpoint() {
        return ResponseEntity.ok(requestService.getRequestTimestamp());
    }
    @PostConstruct
    public void init() {
        System.out.println("🔍 Controller initialized");
        System.out.println("🧪 requestScopedService proxy: " + requestService.getClass());
       // System.out.println("🧪 requestScopedService proxy: " + requestService.getRequestTimestamp());
        // So SPring will create a proxy as no request is there hence it won't be able to call it's method
        // It will fail with ScopeNotActiveException

    }
}
