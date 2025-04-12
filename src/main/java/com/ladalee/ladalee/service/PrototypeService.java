package com.ladalee.ladalee.service;

import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeService {
    private final String id = UUID.randomUUID().toString();

    public PrototypeService() {
        System.out.println("Prototype instance ID: " + id);
    }

    public String getPrototypeId() {
      return id;
    }
}
