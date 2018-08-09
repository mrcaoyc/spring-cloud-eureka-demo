package com.example.controller;

import com.example.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author CaoYongCheng
 */
@RestController
@Slf4j
public class UserController {

    private List<User> users;

    @Autowired
    private Environment environment;

    public UserController() {
        users = new ArrayList<>();
        users.add(new User(1, "小王"));
        users.add(new User(2, "小李"));
        users.add(new User(3, "小张"));
    }

    @GetMapping("/users/{userId}")
    public HttpEntity<?> getUser(@PathVariable("userId") Integer userId) {
        log.info("UserService 端口 {} ", environment.getProperty("server.port"));
        Optional<User> optionalUser = users.stream().filter(user -> Objects.equals(user.getId(), userId)).findFirst();
        return optionalUser.map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
