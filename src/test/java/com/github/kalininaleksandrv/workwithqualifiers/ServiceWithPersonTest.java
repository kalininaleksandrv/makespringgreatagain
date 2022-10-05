package com.github.kalininaleksandrv.workwithqualifiers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ServiceWithPersonTest {

    @Autowired
    ServiceWithEmployee serviceWithEmployee;
    @Autowired
    ServiceWithUser serviceWithUser;
    @Autowired
    ServiceWithAdmin serviceWithAdmin;

    @Test
    void whatPerson() {
        assertEquals("user", serviceWithUser.whatPerson());
        assertEquals("employee", serviceWithEmployee.whatPerson());
        assertEquals("admin", serviceWithAdmin.whatPerson());
    }
}