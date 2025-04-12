package com.ladalee.ladalee.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class LadaleeMoodService {

    LadaleeMoodService(){
        System.out.println("Initialising Bean Ladalee Mood Service");
    }

    public String getMoodBasedOnActionAndPerson(String person, String action) {

        if (person != null && person.toLowerCase().contains("sagar")) {
            return "Fuck Off";
        }
    
        if (action != null && action.equalsIgnoreCase("Waking up")) {
            return "Lazy ho sone do";
        }
    
        return "Happy Baby";
    }
    

}
