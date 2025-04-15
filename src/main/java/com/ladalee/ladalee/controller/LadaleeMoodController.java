package com.ladalee.ladalee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ladalee.ladalee.service.LadaleeMoodService;

@RestController
@Scope(value = "singleton") // Corrected typo from "singelton" to "singleton"
@RequestMapping(value = "/getMood") // Added slash to follow REST conventions
public class LadaleeMoodController {

    LadaleeMoodController(){
        System.out.println("Initialising Bean Ladalee Mood Controller");
    }

    @Autowired
    private LadaleeMoodService ladaleeMoodService;

   

    @GetMapping("/")
    public ResponseEntity<String> getMoodBasedOnActionAndPerson(
            @RequestParam String person,
            @RequestParam String action) {

        String response = ladaleeMoodService.getMoodBasedOnActionAndPerson(person, action);
        return ResponseEntity.ok().body(response);
    }
}
