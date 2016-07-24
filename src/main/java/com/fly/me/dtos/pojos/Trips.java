package com.fly.me.dtos.pojos;

public class Trips {
    private TripOption[] tripOption;

    private String requestId;

    private Data data;

    private String kind;

    public TripOption[] getTripOption() {
        return tripOption;
    }

    public void setTripOption(TripOption[] tripOption) {
        this.tripOption = tripOption;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [tripOption = " + tripOption + ", requestId = " + requestId + ", data = " + data + ", kind = " + kind + "]";
    }
}
