package com.github.kalininaleksandrv.validation;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
public class AddressController {

    /*
    more correct way is to create @ControllerAdvice and process errors in one place,
    but for the simplicity here we convert response type to ? to have the ability
    to return either saved instance or list of constraint violation
    we can't use ResponseStatusException because it not pass messages values by default
     */

    @PostMapping(value = "/address")
    public ResponseEntity<?> newAddress(@RequestBody @Valid Address address, Errors errors) {
        if (errors.hasErrors()) {
            String reason = errors
                    .getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return new ResponseEntity<>("{ \"error\": \"" + reason + "\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
