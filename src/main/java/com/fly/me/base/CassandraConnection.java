package com.fly.me.base;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.springframework.stereotype.Component;

@Component
public class CassandraConnection {

    protected Session session = null;
    protected Cluster cluster = null;

    private final String KEYSPACE = "flights";
    private final String CONTACT_POINTS = "192.168.1.16";

    public CassandraConnection() {
    }

    public void connect() {
        //Connect to the cluster and keyspace "flights"
        String contactPoints = CONTACT_POINTS;
        System.out.println("Contact Points: " + contactPoints);
        cluster = Cluster.builder().addContactPoint(contactPoints).build();
        session = cluster.connect(KEYSPACE);
    }

    public void runQuery() {
        ResultSet results = session.execute("SELECT name FROM test WHERE id = 4dffb4b0-4c5a-11e6-83c4-b327a45bb8ce;");
        for (Row row : results) {
            System.out.format("Result: %s\n", row.getString("name"));
        }
    }

    public ResultSet runCustomQuery(String query) {
        return session.execute(query);
    }

    public void close() {
        session.close();
    }

    public void checkConnection() {
        if (session == null || session.isClosed()) {
            this.connect();
        }
    }
}
