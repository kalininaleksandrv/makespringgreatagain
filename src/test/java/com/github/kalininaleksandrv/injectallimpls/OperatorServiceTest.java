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
        assertAll(
                () -> assertTrue(operatorService.performOperations().contains("operator 1")),
                () -> assertTrue(operatorService.performOperations().contains("operator 2")),
                () -> assertTrue(operatorService.performOperations().contains("operator 3")));
    }

    @Test
    void performExactOperations() {
        assertEquals("data after operator 2 ", operatorService.performExactOperations("SecondOperator"));
    }

    @Test
    void performExactOperationUnknownOperator() {
        RuntimeException ex = assertThrows(RuntimeException.class,
                () -> operatorService.performExactOperations("unknown"));
        assertEquals("Operator not found", ex.getMessage());
    }
}