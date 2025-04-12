package com.ladalee.ladalee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladalee.ladalee.service.PrototypeService;

@RestController

@RequestMapping("/prototype")
public class PrototypeController {

    @Autowired
    private PrototypeService prototypeServiceProvider;

    @GetMapping
    public ResponseEntity<String> prototypeEndpoint() {
        return ResponseEntity.ok(prototypeServiceProvider.getPrototypeId());
    }
}
