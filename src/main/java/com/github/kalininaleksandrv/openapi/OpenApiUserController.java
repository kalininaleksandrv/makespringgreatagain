package com.github.kalininaleksandrv.openapi;

import com.github.kalininaleksandrv.openapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class OpenApiUserController implements V1Api {

    private final DumbUserService dumbUserService;

    @Override
    public ResponseEntity<User> addUser(User user) {
        return new ResponseEntity<>(dumbUserService.addUser(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getUserById(Integer userId) {
        return new ResponseEntity<>(dumbUserService.getUserById(userId), HttpStatus.OK);
    }
}
