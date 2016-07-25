package com.fly.me.controllers;

import com.fly.me.services.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthCheckController {

    @Autowired
    protected HealthCheckService healthCheckService;

    @RequestMapping("/healthcheck")
    public @ResponseBody
    String healthCheck() {
        return healthCheckService.performHealthCheck();
    }

}
