package com.fly.me.dtos.pojos;

public class SearchResponse {

    private Trips trips;

    private String kind;

    public Trips getTrips() {
        return trips;
    }

    public void setTrips(Trips trips) {
        this.trips = trips;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [trips = " + trips + ", kind = " + kind + "]";
    }
}
