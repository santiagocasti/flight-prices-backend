package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.fasterxml.jackson.annotation.JsonView;
import com.fly.me.Views.JacksonViews;

@Table(keyspace = "flights", name = "flattened_trip_option")
public class FlattenedTripOption {

    @PartitionKey
    @Column(name = "flight_code")
    @JsonView(JacksonViews.FlattenedTripOption.PriceList.class)
    private String flightCode;

    @ClusteringColumn(0)
    @JsonView(JacksonViews.FlattenedTripOption.PriceList.class)
    private String date;

    @ClusteringColumn(1)
    @JsonView(JacksonViews.FlattenedTripOption.PriceList.class)
    private String time;

    @ClusteringColumn(2)
    @JsonView(JacksonViews.FlattenedTripOption.PriceList.class)
    private Float price;

    @JsonView(JacksonViews.FlattenedTripOption.DetailedPriceList.class)
    private String id;

    @Column(name = "flight_code_out")
    @JsonView(JacksonViews.FlattenedTripOption.DetailedPriceList.class)
    private String flightCodeThere;

    @Column(name = "flight_code_return")
    @JsonView(JacksonViews.FlattenedTripOption.DetailedPriceList.class)
    private String flightCodeBack;

    @JsonView(JacksonViews.FlattenedTripOption.PriceList.class)
    private String currency;

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightCodeThere() {
        return flightCodeThere;
    }

    public void setFlightCodeThere(String flightCodeThere) {
        this.flightCodeThere = flightCodeThere;
    }

    public String getFlightCodeBack() {
        return flightCodeBack;
    }

    public void setFlightCodeBack(String flightCodeBack) {
        this.flightCodeBack = flightCodeBack;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
