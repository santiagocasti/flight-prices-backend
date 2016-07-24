package com.fly.me.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.base.CassandraConnection;
import com.fly.me.base.CassandraConnector;
import com.fly.me.dtos.pojos.Airport;
import org.springframework.stereotype.Repository;

@Repository
public class FlightsRepository {

    private CassandraConnector connector = CassandraConnector.getInstance();

    public FlightsRepository() {

    }

    public void executeQuery() {
        CassandraConnection connection = connector.getConnection();
        connection.runQuery();
    }

    public void saveAirport(Airport a) {
        CassandraConnection connection = connector.getConnection();
        ObjectMapper mapper = new ObjectMapper();

        String airportJson = null;
        try {
            airportJson = mapper.writeValueAsString(a);
            System.out.println("airportJson: " + airportJson);
        } catch (JsonProcessingException e) {
            System.out.println("Exception converting airport to JSON. Airport { code[" + a.getCode() + "], city[" + a.getCity() + "], name[" + a.getName());
            e.printStackTrace();
        }

        connection.runCustomQuery("INSERT INTO airport JSON  '" + airportJson + "'");
    }
}
