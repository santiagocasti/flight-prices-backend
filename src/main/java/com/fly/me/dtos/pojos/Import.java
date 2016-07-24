package com.fly.me.dtos.pojos;


public class Import {
    protected String date;
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
