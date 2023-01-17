package com.github.kalininaleksandrv.openapi;

import com.github.kalininaleksandrv.openapi.model.Address;
import com.github.kalininaleksandrv.openapi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DumbUserService {
    public User getUserById(int id) {
        log.info("###### request user with id {}", id);
        User u = new User();
        Address a = new Address();
        u.setId(1L);
        u.setName("John");
        a.setZip("111222");
        a.setStreet("Lenina st");
        u.setAddress(a);
        return u;
    }

    public User addUser (User user){
        log.info("###### persist user " + user.toString());
        return user;
    }
}
