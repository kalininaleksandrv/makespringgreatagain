package com.github.kalininaleksandrv.workwithcontext;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class MyServiceToInjectBeanTest {

    @Autowired
    MyServiceToInjectBean myServiceToInjectBean;

    @Test
    void doSomething() {
        /*
        in a test we make sure that SomeService added dynamically to context is exist
        and our value, we put on bean creation - remains the same (100)
         */
       assertEquals("100", myServiceToInjectBean.doSomething());
    }
}