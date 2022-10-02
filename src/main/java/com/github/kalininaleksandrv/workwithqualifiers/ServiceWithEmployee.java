package com.github.kalininaleksandrv.workwithqualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceWithEmployee {

    /*
     since we use @Qualifier (on a Person implementations),
     if both the @Qualifier and @Primary annotations are present,
     then the @Qualifier annotation will have precedence
    */
    @Autowired
    @Qualifier("employeePerson")
    Person person;

    String whatPerson() {
        return person.getPersonType();
    }
}
