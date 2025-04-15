package com.ladalee.ladalee.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//static method to get singelton bean 
@Component
public class LadaleeApplicationBeanContext  implements ApplicationContextAware{

   private  static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       LadaleeApplicationBeanContext.applicationContext=applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

}
