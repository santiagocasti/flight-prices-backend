package com.fly.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This annotation is equivalent to having:
 * - @Configuration
 * - @EnableAutoConfiguration
 * - @ComponentScan
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Starting app...");
    }
}
