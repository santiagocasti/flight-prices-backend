package com.fly.me.dtos.pojos.qpx;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class QPXSliceParameter {
    public String origin;
    public String destination;
    public String date;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ObjectNode getJsonNode() {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode parentNode = mapper.createObjectNode();

        parentNode.put("origin", origin);
        parentNode.put("destination", destination);
        parentNode.put("date", date);

        return parentNode;
    }
}
