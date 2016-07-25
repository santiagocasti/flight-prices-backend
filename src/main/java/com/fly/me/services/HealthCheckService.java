package com.fly.me.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.dtos.pojos.Import;
import com.fly.me.repositories.CassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    @Autowired
    protected CassandraRepository cassandraRepository;

    @Autowired
    protected ImportsService importsService;

    public String performHealthCheck() {

        Import imp = importsService.getLast();

        ObjectMapper mapper = new ObjectMapper();

        String result = "";

        try {
            result = mapper.writeValueAsString(imp);
        } catch (JsonProcessingException e) {
            System.out.println("Exception while converting object to JSON.");
            e.printStackTrace();
        }

        return result;
    }

}
