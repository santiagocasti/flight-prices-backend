package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "flights", name = "leg")
public class Leg {
    private String originTerminal;

    private Integer mileage;

    private Boolean secure;

    private String departureTime;

    private String origin;

    private String destinationTerminal;

    private Integer onTimePerformance;

    private String kind;

    private String destination;

    private String id;

    private Integer duration;

    private String arrivalTime;

    private String aircraft;

    private String operatingDisclosure;

    private String meal;

    private Integer connectionDuration;

    private Boolean changePlane;

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public Integer getConnectionDuration() {
        return connectionDuration;
    }

    public void setConnectionDuration(Integer connectionDuration) {
        this.connectionDuration = connectionDuration;
    }

    public Boolean getChangePlane() {
        return changePlane;
    }

    public void setChangePlane(Boolean changePlane) {
        this.changePlane = changePlane;
    }

    public String getOperatingDisclosure() {
        return operatingDisclosure;
    }

    public void setOperatingDisclosure(String operatingDisclosure) {
        this.operatingDisclosure = operatingDisclosure;
    }

    public String getOriginTerminal() {
        return originTerminal;
    }

    public void setOriginTerminal(String originTerminal) {
        this.originTerminal = originTerminal;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Boolean getSecure() {
        return secure;
    }

    public void setSecure(Boolean secure) {
        this.secure = secure;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestinationTerminal() {
        return destinationTerminal;
    }

    public void setDestinationTerminal(String destinationTerminal) {
        this.destinationTerminal = destinationTerminal;
    }

    public Integer getOnTimePerformance() {
        return onTimePerformance;
    }

    public void setOnTimePerformance(Integer onTimePerformance) {
        this.onTimePerformance = onTimePerformance;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public String toString() {
        return "ClassPojo [originTerminal = " + originTerminal + ", mileage = " + mileage + ", secure = " + secure + ", departureTime = " + departureTime + ", origin = " + origin + ", destinationTerminal = " + destinationTerminal + ", onTimePerformance = " + onTimePerformance + ", kind = " + kind + ", destination = " + destination + ", id = " + id + ", duration = " + duration + ", arrivalTime = " + arrivalTime + ", aircraft = " + aircraft + "]";
    }
}