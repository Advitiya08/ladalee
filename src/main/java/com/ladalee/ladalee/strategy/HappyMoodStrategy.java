package com.ladalee.ladalee.strategy;

import org.springframework.stereotype.Component;

@Component("happyMood")
public class HappyMoodStrategy  implements MoodStrategy{

    @Override
    public String getMood() {
        return "I am feeling 😊";
    }

}
