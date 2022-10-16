package com.github.kalininaleksandrv.controlleradvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

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

    // TODO: 16.10.2022 make method get type of returned object from annotation or generify
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        //if controller returns list of elements we must wrap each element
        if (Collection.class.isAssignableFrom(Objects.requireNonNull(body).getClass())) {
            try {
                Collection<?> bodyCollection = (Collection<?>) body;
                if (bodyCollection.isEmpty()) {
                    return body;
                }
                return bodyCollection
                        .stream()
                        .map(i -> new PersonWrapper((Person) i, true))
                        .collect(Collectors.toList());
            } catch (Exception e) {
                return body;
            }
        }
        return new PersonWrapper((Person) body, true);
    }
}
