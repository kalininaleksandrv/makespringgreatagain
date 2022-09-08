package com.github.kalininaleksandrv.workwithcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
@Service
public class MyServiceToInjectBean {

    /*
    we inject SomeService from context
     */
    @Autowired
    SomeService someService;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomething() {
        /*
        we make sure that our value, we put on bean creation - remains the same (100)
         */
        String randomNumberAsString = someService.getRandomNumberAsString();
        System.out.println(randomNumberAsString);
    }
}
