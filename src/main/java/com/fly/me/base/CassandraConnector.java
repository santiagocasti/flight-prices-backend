package com.fly.me.base;

import com.datastax.driver.core.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.logging.Logger;

@Component
public class CassandraConnector {

    protected static Session session = null;
    protected static Cluster cluster = null;
    private static final Logger logger = Logger.getLogger(CassandraConnector.class.toString());

    private final String KEYSPACE = "flights";
//    private final String CONTACT_POINTS = "172.31.30.63"; //52.58.49.7
    private final String CONTACT_POINTS = "192.168.1.16"; //52.58.49.7

    protected static HashMap<String, PreparedStatement> statementHashMap = new HashMap<>();

    protected CassandraConnector() {
        checkConnection();
    }

    public ResultSet runInsertJson(String table, String json) {

        String query = "INSERT INTO " + table + " JSON ? ";
        PreparedStatement statement = this.getPreparedStatement(query);

        BoundStatement boundStatement = new BoundStatement(statement);
        boundStatement = boundStatement.bind(json);
        logger.info("BoundStatement: " + boundStatement.toString());
        return session.execute(boundStatement);
    }

    public PreparedStatement getPreparedStatement(String query) {

        String key = Integer.toString(query.hashCode());

        if (!statementHashMap.containsKey(key)) {
            PreparedStatement statement = session.prepare(query);
            statementHashMap.put(key, statement);
        }

        return statementHashMap.get(key);
    }

    public ResultSet execute(BoundStatement boundStatement) {
        return session.execute(boundStatement);
    }

    protected void connect() {
        //Connect to the cluster and keyspace "flights"
        String contactPoints = CONTACT_POINTS;
        logger.info("Contact Points: " + contactPoints);
        cluster = Cluster.builder().addContactPoint(contactPoints).build();
        session = cluster.connect(KEYSPACE);
    }

    protected void close() {
        if (session != null) {
            session.close();
        }
    }

    protected void checkConnection() {
        if (session == null || session.isClosed()) {
            close();
            connect();
        }
    }
}