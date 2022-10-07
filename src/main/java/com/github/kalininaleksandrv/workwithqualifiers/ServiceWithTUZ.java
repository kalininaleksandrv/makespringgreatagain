package com.github.kalininaleksandrv.workwithqualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWithTUZ {

    @Autowired
    @Version1
    private TechnicalUZ_V1 technicalUZ_v1;

    @Autowired
    @Version2
    private TechnicalUZ_V2 technicalUZ_v2;

    String whatPerson() {
        return technicalUZ_v1.getPersonType()+" "+technicalUZ_v2.getPersonType();
    }

}
