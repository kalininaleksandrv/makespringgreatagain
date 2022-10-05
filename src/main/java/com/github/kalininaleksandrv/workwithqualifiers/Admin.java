package com.github.kalininaleksandrv.workwithqualifiers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class Admin implements Person{
    @Override
    public String getPersonType() {
        return "admin";
    }
}
