package com.fly.me.repositories;

import com.datastax.driver.core.ResultSet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.base.CassandraConnector;
import org.springframework.stereotype.Repository;


@Repository
public class CassandraRepository {

    CassandraConnector connector;

    public CassandraRepository() {
        connector = CassandraConnector.getInstance();
    }

    public Boolean insertJsonObject(String table, Object object) {

        ObjectMapper mapper = new ObjectMapper();

        String json = "";
        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            System.out.println("Exception converting carrier to JSON.");
            ex.printStackTrace();
        }

        ResultSet result = connector.runInsertJson(table, json);

        return result.all().size() == 0;
    }
}
