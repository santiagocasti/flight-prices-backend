package com.fly.me.repositories;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.base.CassandraConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CassandraRepository {

    @Autowired
    CassandraConnector connector;

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


    public PreparedStatement getPreparedStatement(String s) {
        return connector.getPreparedStatement(s);
    }

    public ResultSet execute(BoundStatement boundStatement) {
        return connector.execute(boundStatement);
    }
}
