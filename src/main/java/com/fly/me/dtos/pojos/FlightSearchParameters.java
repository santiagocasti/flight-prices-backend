package com.fly.me.dtos.pojos;


import java.time.LocalDate;

public class FlightSearchParameters {

    public String origin;
    public String destination;
    public int adultCount;
    public LocalDate flightOutDate;
    public LocalDate flightBackDate;
    public Boolean returnFlight;

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

    public int getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(int adultCount) {
        this.adultCount = adultCount;
    }

    public LocalDate getFlightOutDate() {
        return flightOutDate;
    }

    public void setFlightOutDate(LocalDate flightOutDate) {
        this.flightOutDate = flightOutDate;
    }

    public LocalDate getFlightBackDate() {
        return flightBackDate;
    }

    public void setFlightBackDate(LocalDate flightBackDate) {
        this.flightBackDate = flightBackDate;
    }

    public Boolean getReturnFlight() {
        return returnFlight;
    }

    public void setReturnFlight(Boolean returnFlight) {
        this.returnFlight = returnFlight;
    }

    public Boolean isReturnFlight() {
        return returnFlight;
    }
}
