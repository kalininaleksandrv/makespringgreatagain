package com.github.kalininaleksandrv.workwithlazy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class MyServiceToLazyInjectTest {

    @Autowired
    MyServiceToLazyInject myServiceToLazyInject;

    @Test
    void lazyOrNot_NOT() {
        /*
        if lazy parameter is false lazy bean would not been created so in console we will not see "now lazy bean is created"
         */
        assertEquals("ordinary cheap operation", myServiceToLazyInject.lazyOrNot(false));
    }

    @Test
    void lazyOrNot_LAZY() {
        /*
        if lazy parameter is true lazy bean will be created so in console we will see "now lazy bean is created"
         */
        assertEquals("very expensive processing", myServiceToLazyInject.lazyOrNot(true));
    }
}