package com.ladalee.ladalee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ladalee.ladalee.strategy.MoodStrategy;



@Component
@Scope(value="singleton")
public class LadaleeMoodService {

    @Autowired ApplicationContext applicationContext;

    @Autowired MoodService moodService;

    MoodStrategy moodStrategy;

    LadaleeMoodService(){
        System.out.println("Initialising Bean Ladalee Mood Service");
    }

    public String getMoodBasedOnActionAndPerson(String person, String action) {

        if (person != null && person.toLowerCase().contains("sagar")) {
            moodStrategy=(MoodStrategy) applicationContext.getBean("sadMood") ;
          
        }
    
        else if (action != null && action.equalsIgnoreCase("Waking up")) {
            return "Lazy ho sone do";
        }
        else{
        moodStrategy=(MoodStrategy) applicationContext.getBean("happyMood") ;
        }
        return moodStrategy.getMood();
    }
    

}
