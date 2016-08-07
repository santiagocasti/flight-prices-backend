package com.fly.me.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.base.CassandraRepository;
import com.fly.me.dtos.pojos.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class HealthCheckService {

    @Autowired
    protected CassandraRepository cassandraRepository;

    @Autowired
    protected ImportsService importsService;

    private final Logger logger = Logger.getLogger(HealthCheckService.class.toString());

    public String performHealthCheck() {

        Import imp = importsService.getLast();

        ObjectMapper mapper = new ObjectMapper();

        String result = "";

        try {
            result = mapper.writeValueAsString(imp);
        } catch (JsonProcessingException e) {
            logger.info("Exception while converting object to JSON.");
            e.printStackTrace();
        }

        return result;
    }

}
