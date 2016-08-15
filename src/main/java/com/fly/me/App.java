package com.fly.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
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
public class App extends SpringBootServletInitializer {

    private static final Logger logger = Logger.getLogger(App.class.toString());

    // Used when launching as an executable jar or war
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);
        logger.info("Starting app from executing a jar/war...");
    }

    // used when deploying to a standalone servlet container
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        logger.info("Starting app from standalone servlet container");
        return applicationBuilder.sources(App.class);
    }
}
