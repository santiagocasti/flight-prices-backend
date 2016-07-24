package com.fly.me.dtos.pojos;

public class Data {
    private Airport[] airport;

    private GeneralTax[] tax;

    private Aircraft[] aircraft;

    private Carrier[] carrier;

    private String kind;

    private City[] city;

    public Airport[] getAirport() {
        return airport;
    }

    public void setAirport(Airport[] airport) {
        this.airport = airport;
    }

    public GeneralTax[] getTax() {
        return tax;
    }

    public void setTax(GeneralTax[] tax) {
        this.tax = tax;
    }

    public Aircraft[] getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft[] aircraft) {
        this.aircraft = aircraft;
    }

    public Carrier[] getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier[] carrier) {
        this.carrier = carrier;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public City[] getCity() {
        return city;
    }

    public void setCity(City[] city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ClassPojo [airport = " + airport + ", tax = " + tax + ", aircraft = " + aircraft + ", carrier = " + carrier + ", kind = " + kind + ", city = " + city + "]";
    }
}