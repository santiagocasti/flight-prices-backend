package com.fly.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
// this is necessary for the app to scan any file under com.flyme
// by default it scans from the current directory down that path
@ComponentScan(basePackages = "com.fly.me")
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Starting app...");
    }
}
