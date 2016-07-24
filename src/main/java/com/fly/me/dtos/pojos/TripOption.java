package com.fly.me.dtos.pojos;

public class TripOption {
    private Pricing[] pricing;

    private String id;

    private String saleTotal;

    private Slice[] slice;

    private String kind;

    private String date;

    private String time;

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

    public Pricing[] getPricing() {
        return pricing;
    }

    public void setPricing(Pricing[] pricing) {
        this.pricing = pricing;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(String saleTotal) {
        this.saleTotal = saleTotal;
    }

    public Slice[] getSlice() {
        return slice;
    }

    public void setSlice(Slice[] slice) {
        this.slice = slice;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [pricing = " + pricing + ", id = " + id + ", saleTotal = " + saleTotal + ", slice = " + slice + ", kind = " + kind + "]";
    }
}
