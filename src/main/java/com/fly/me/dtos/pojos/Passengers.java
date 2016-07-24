package com.fly.me.dtos.pojos;

public class Passengers {
    private String adultCount;

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

    public String getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(String adultCount) {
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