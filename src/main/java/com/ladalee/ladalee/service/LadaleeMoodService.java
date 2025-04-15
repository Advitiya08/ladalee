package com.ladalee.ladalee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.ladalee.ladalee.strategy.MoodStrategy;

@Component
@Scope(value = "singleton")
public class LadaleeMoodService {

    private final MoodStrategy happyMood;
    private final MoodStrategy sadMood;

    @Autowired
    public LadaleeMoodService(
        @Qualifier("happyMood") MoodStrategy happyMood,
        @Qualifier("sadMood") MoodStrategy sadMood
    ) {
        this.happyMood = happyMood;
        this.sadMood = sadMood;
        System.out.println("Initialising Bean Ladalee Mood Service");
    }

    public String getMoodBasedOnActionAndPerson(String person, String action) {

        if (person != null && person.toLowerCase().contains("sagar")) {
            return sadMood.getMood();
        }

        if (action != null && action.equalsIgnoreCase("Waking up")) {
            return "Lazy ho sone do";
        }

        return happyMood.getMood();
    }
}
