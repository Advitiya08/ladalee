package com.ladalee.ladalee.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

public class ConsoleAuditLogger {
  @ConditionalOnProperty(name = "audit.enabled", havingValue  = "true")
    public void log(String message) {
        System.out.println("🔍 AUDIT: " + message);
    }

}
