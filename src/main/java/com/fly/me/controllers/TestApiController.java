package com.fly.me.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {

    @RequestMapping("/hello")
    public @ResponseBody String runTest(){
            return "Hello stranger!";
    }

    public static void main(String[] args) throws Exception {
        System.out.println("starting controller");
    }
}
