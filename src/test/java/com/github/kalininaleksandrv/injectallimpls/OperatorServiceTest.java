package com.github.kalininaleksandrv.injectallimpls;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class OperatorServiceTest {

    @Autowired
    OperatorService operatorService;

    @Test
    void performOperations() {
        assertEquals("data after operator 1  after operator 2  after operator 3 ",
                operatorService.performOperations());
    }
}