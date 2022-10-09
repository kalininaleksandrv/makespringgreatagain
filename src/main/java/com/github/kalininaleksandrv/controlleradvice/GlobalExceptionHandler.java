package com.github.kalininaleksandrv.controlleradvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.AbstractMap;

@ControllerAdvice
@Component
public class GlobalExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(Exception exception) {
        LOG.error("Request could not be processed: ", exception);

        if (exception instanceof PersonProcessingException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AbstractMap.SimpleEntry<>("message", exception.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new AbstractMap.SimpleEntry<>("message", "Request could not be processed"));
    }
}
