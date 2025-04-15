package com.ladalee.ladalee.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ladalee.ladalee.strategy.MoodStrategy;

@Service
public class MoodService {

    @Autowired
    private ApplicationContext context;

    public String getMoodByType(String moodType) {
        // Use qualifier name dynamically to get the right bean
        MoodStrategy strategy = (MoodStrategy) context.getBean(moodType + "Strategy");
        return strategy.getMood();
    }
}
