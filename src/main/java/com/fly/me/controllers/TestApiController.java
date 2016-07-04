package com.fly.me.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {

    @RequestMapping("/test")//, method=RequestMethod.GET
    public @ResponseBody
    String runTest(){
            return "Hello stranger!";
    }
}
