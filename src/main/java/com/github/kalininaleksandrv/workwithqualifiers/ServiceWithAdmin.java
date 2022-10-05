package com.github.kalininaleksandrv.workwithqualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceWithAdmin {

    /*
    here we are not define qualifier so bean will be injected by name
    but in a bean we must add @Qualifier without a value
     */
    @Autowired
    @Qualifier
    Person admin;

    String whatPerson() {
        return admin.getPersonType();
    }
}
