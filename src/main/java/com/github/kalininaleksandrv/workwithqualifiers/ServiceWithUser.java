package com.github.kalininaleksandrv.workwithqualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWithUser {

    /*
    since User annotated as a @Primary method will return "user"
     */
    @Autowired
    Person person;

    String whatPerson() {
        return person.getPersonType();
    }
}
