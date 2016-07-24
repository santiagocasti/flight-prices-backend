package com.fly.me.base;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CassandraConnector {

    protected static CassandraConnector instance = null;

    protected static CassandraConnection connection = null;

    protected static HashMap<String, PreparedStatement> statementHashMap = new HashMap<>();

    protected CassandraConnector() {
        // Exists only to defeat instantiation
    }

    public static CassandraConnector getInstance() {

        createInstance();

        return instance;
    }

    public static void createInstance() {

        if (instance == null) {
            instance = new CassandraConnector();
        }

        if (connection == null) {
            connection = new CassandraConnection();
            connection.connect();
        }
    }

    public CassandraConnection getConnection() {
        connection.checkConnection();
        return connection;
    }

    public ResultSet runInsertJson(String table, String json) {

        PreparedStatement statement = this.getInsertJsonPreparedStatement(table);

        BoundStatement boundStatement = new BoundStatement(statement);
        System.out.println(boundStatement.toString());
        boundStatement = boundStatement.bind(json);
        System.out.println(boundStatement.toString());
        return connection.session.execute(boundStatement);

    }

    protected PreparedStatement getInsertJsonPreparedStatement(String table) {

        String key = "insert-" + table;

        if (!statementHashMap.containsKey(key)) {
            PreparedStatement statement = connection.session.prepare(
                    "INSERT INTO " + table + " JSON ? "
            );
            statementHashMap.put(key, statement);
        }

        return statementHashMap.get(key);
    }

}