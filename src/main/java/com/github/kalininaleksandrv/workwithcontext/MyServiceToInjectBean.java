package com.github.kalininaleksandrv.workwithcontext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MyServiceToInjectBean {

    /*
    we inject SomeService from context
     */
    @Autowired
    SomeService someService;

    public String doSomething() {
        return someService.getRandomNumberAsString();
    }
}
