package com.github.kalininaleksandrv.workwithqualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("userPerson")
public class User implements Person{
    @Override
    public String getPersonType() {
        return "user";
    }
}
