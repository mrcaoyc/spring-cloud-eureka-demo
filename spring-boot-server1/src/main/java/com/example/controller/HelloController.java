package com.example.controller;

import com.example.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CaoYongCheng
 */
@RestController
public class HelloController {



    @GetMapping(value = "hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person index() {
        Person person = new Person();
        person.setId(1);
        person.setName("caoyc");

        return person;
    }
}
