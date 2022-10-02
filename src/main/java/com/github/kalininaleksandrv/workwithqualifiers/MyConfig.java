package com.github.kalininaleksandrv.workwithqualifiers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfig {

    /*
    since we use two beans of the same type, we must explicitly declare
    which one will be created by default with @Primary
     */

    @Bean
    public Person getEmployee(){
        return new Employee();
    }

    @Bean
    @Primary
    public Person getUser() {
        return new User();
    }
}
