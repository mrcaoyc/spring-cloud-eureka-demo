package com.example.controller;

import com.example.client.UserClient;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CaoYongCheng
 */
@RestController
public class HelloController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/hello/{userId}")
    public String showMsg(@PathVariable("userId") int userId) {
        User user = userClient.getUser(userId);
        return "欢迎您：{"+user.getName()+"}";
    }
}
