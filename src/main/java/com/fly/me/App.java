package com.fly.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.logging.Logger;

/**
 * This annotation is equivalent to having:
 * - @Configuration
 * - @EnableAutoConfiguration
 * - @ComponentScan
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class App {

    private static final Logger logger = Logger.getLogger(App.class.toString());

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);

        logger.info("[s] Starting app...");
    }
}
