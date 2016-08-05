package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "flights", name = "passengers")
public class Passengers {
    private Integer adultCount;

    private String kind;

    private Integer childCount;

    private Integer infantInLapCount;

    private Integer infantInSeatCount;

    private Integer seniorCount;

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Integer getInfantInLapCount() {
        return infantInLapCount;
    }

    public void setInfantInLapCount(Integer infantInLapCount) {
        this.infantInLapCount = infantInLapCount;
    }

    public Integer getInfantInSeatCount() {
        return infantInSeatCount;
    }

    public void setInfantInSeatCount(Integer infantInSeatCount) {
        this.infantInSeatCount = infantInSeatCount;
    }

    public Integer getSeniorCount() {
        return seniorCount;
    }

    public void setSeniorCount(Integer seniorCount) {
        this.seniorCount = seniorCount;
    }

    public Integer getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(Integer adultCount) {
        this.adultCount = adultCount;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [adultCount = " + adultCount + ", kind = " + kind + "]";
    }
}