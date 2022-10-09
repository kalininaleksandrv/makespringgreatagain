package com.github.kalininaleksandrv.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Version1
public class PersonController {

    @GetMapping(value = "/persons/{id}")
    ResponseEntity<Person> getPerson(@PathVariable Long id) {
        if(id == 0) throw new RuntimeException();
        if (id == 1) {
            return new ResponseEntity<>(new Person(1, "John Doe"), HttpStatus.OK);
        }
        throw new PersonProcessingException("no such person");
    }
}
