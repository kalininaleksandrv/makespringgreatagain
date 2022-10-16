package com.github.kalininaleksandrv.controlleradvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/*
works only if class marked as a Version1
 */
@ControllerAdvice(annotations = Version1.class)
public class PersonControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {

        //if we find @DisableWrapper above method - advice will be disabled
        for (Annotation a: returnType.getMethodAnnotations()) {
            if (a.annotationType() == DisableWrapper.class) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        return new PersonWrapper((Person) body, true);
    }
}
