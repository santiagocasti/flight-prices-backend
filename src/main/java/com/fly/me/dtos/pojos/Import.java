package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "flights", name = "import")
public class Import {

    @PartitionKey
    protected String date;

    @ClusteringColumn(0)
    protected String time;

    protected int numResults;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numImports) {
        this.numResults = numImports;
    }
}
