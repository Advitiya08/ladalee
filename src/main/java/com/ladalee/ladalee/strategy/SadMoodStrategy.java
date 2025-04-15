package com.ladalee.ladalee.strategy;

import org.springframework.stereotype.Component;

@Component("sadMood")
public class SadMoodStrategy implements MoodStrategy{

    @Override
    public String getMood() {
        return"I am feeling sad :)";
    }
}
