package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author CaoYongCheng
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication1.class, args);
    }
}
