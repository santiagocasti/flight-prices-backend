package com.fly.me.dtos.pojos.qpx;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.util.ArrayList;

public class QPXSearchParameters {
    public int adultCount;
    public ArrayList<QPXSliceParameter> slice = new ArrayList<QPXSliceParameter>();

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public ArrayList<QPXSliceParameter> getSlice() {
        return slice;
    }

    public void setSlice(ArrayList<QPXSliceParameter> slice) {
        this.slice = slice;
    }

    public void addSlice(QPXSliceParameter slice) {
        this.slice.add(slice);
    }

    public JsonNode toJSON() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode parentNode = mapper.createObjectNode();

        ObjectNode requestNode = parentNode.putObject("request");

        ObjectNode passengerNode = requestNode.putObject("passengers");
        passengerNode.put("adultCount", adultCount);

        ArrayNode sliceNode = requestNode.putArray("slice");

        int i = 0;
        for (QPXSliceParameter slice : this.slice) {
            sliceNode.insert(i++, slice.getJsonNode());
        }

        return new ObjectMapper().readTree(parentNode.toString());
    }
}
