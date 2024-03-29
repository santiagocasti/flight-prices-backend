package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "flights", name = "flight")
public class Flight {
    private String carrier;

    private String number;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ClassPojo [carrier = " + carrier + ", number = " + number + "]";
    }
}
