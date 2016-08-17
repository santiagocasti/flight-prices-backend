package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.fasterxml.jackson.annotation.JsonView;
import com.fly.me.Views.JacksonViews;

@Table(keyspace = "flights", name = "flight_tuples_by_journey")
public class FlightTuple {
    @PartitionKey
    @Column(name = "journey_code")
    @JsonView(JacksonViews.FlightTuple.Detailed.class)
    private String journeyCode;

    @ClusteringColumn(0)
    @Column(name = "flight_out_code")
    @JsonView(JacksonViews.FlightTuple.Basic.class)
    private String flightOutCode;

    @ClusteringColumn(1)
    @Column(name = "return_flight_code")
    @JsonView(JacksonViews.FlightTuple.Basic.class)
    private String returnFlightCode;

    public String getJourneyCode() {
        return journeyCode;
    }

    public void setJourneyCode(String journeyCode) {
        this.journeyCode = journeyCode;
    }

    public String getFlightOutCode() {
        return flightOutCode;
    }

    public void setFlightOutCode(String flightOutCode) {
        this.flightOutCode = flightOutCode;
    }

    public String getReturnFlightCode() {
        return returnFlightCode;
    }

    public void setReturnFlightCode(String returnFlightCode) {
        this.returnFlightCode = returnFlightCode;
    }
}
