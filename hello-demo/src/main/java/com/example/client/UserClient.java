package com.example.client;

import com.example.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CaoYongCheng
 */
@FeignClient(name = "user-service")
public interface UserClient {
    @RequestMapping("/users/{userId}")
    User getUser(@PathVariable("userId") Integer userId);
}
