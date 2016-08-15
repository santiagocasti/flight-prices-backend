package com.fly.me.controllers;

import com.fly.me.services.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HealthCheckController {

    protected static Logger logger = Logger.getLogger(HealthCheckController.class.toString());
    @Autowired
    protected HealthCheckService healthCheckService;

    @RequestMapping("/healthcheck")
    public
    @ResponseBody
    String healthCheck() {
        logger.info("Handling /healthcheck ...");
        return healthCheckService.performHealthCheck();
    }

}
