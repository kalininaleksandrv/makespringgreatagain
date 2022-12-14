package com.github.kalininaleksandrv.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Version1 //only controllers, annotated Version1 will be processed with ControlledAdvice (see "annotation" param)
public class PersonController {

    @GetMapping(value = "/persons/{id}")
    ResponseEntity<Person> getPerson(@PathVariable Long id) {
        if (id == 0) throw new RuntimeException();
        if (id == 1) {
            return new ResponseEntity<>(new Person(1, "John Doe"), HttpStatus.OK);
        }
        throw new PersonProcessingException("no such person");
    }

    @DisableWrapper
    @GetMapping(value = "/persons")
    ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(List.of(new Person(1, "John"), new Person(2, "Jane")), HttpStatus.OK);
    }

    @GetMapping(value = "/admins")
    /*
    this method demonstrate ability of wrapper to wrap elements inside collection
     */
    ResponseEntity<List<Person>> getAllAdmins() {
        return new ResponseEntity<>(List.of(new Person(1, "John"), new Person(2, "Jane")), HttpStatus.OK);
    }
}
