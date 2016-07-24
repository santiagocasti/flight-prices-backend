package com.fly.me.dtos.pojos;

public class Pricing {
    private String baseFareTotal;

    private Passengers passengers;

    private String saleFareTotal;

    private Tax[] tax;

    private String saleTotal;

    private Fare[] fare;

    private SegmentPricing[] segmentPricing;

    private String fareCalculation;

    private String saleTaxTotal;

    private String latestTicketingTime;

    private String ptc;

    private String kind;

    private Boolean refundable;

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
    }

    public String getBaseFareTotal() {
        return baseFareTotal;
    }

    public void setBaseFareTotal(String baseFareTotal) {
        this.baseFareTotal = baseFareTotal;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public void setPassengers(Passengers passengers) {
        this.passengers = passengers;
    }

    public String getSaleFareTotal() {
        return saleFareTotal;
    }

    public void setSaleFareTotal(String saleFareTotal) {
        this.saleFareTotal = saleFareTotal;
    }

    public Tax[] getTax() {
        return tax;
    }

    public void setTax(Tax[] tax) {
        this.tax = tax;
    }

    public String getSaleTotal() {
        return saleTotal;
    }

    public void setSaleTotal(String saleTotal) {
        this.saleTotal = saleTotal;
    }

    public Fare[] getFare() {
        return fare;
    }

    public void setFare(Fare[] fare) {
        this.fare = fare;
    }

    public SegmentPricing[] getSegmentPricing() {
        return segmentPricing;
    }

    public void setSegmentPricing(SegmentPricing[] segmentPricing) {
        this.segmentPricing = segmentPricing;
    }

    public String getFareCalculation() {
        return fareCalculation;
    }

    public void setFareCalculation(String fareCalculation) {
        this.fareCalculation = fareCalculation;
    }

    public String getSaleTaxTotal() {
        return saleTaxTotal;
    }

    public void setSaleTaxTotal(String saleTaxTotal) {
        this.saleTaxTotal = saleTaxTotal;
    }

    public String getLatestTicketingTime() {
        return latestTicketingTime;
    }

    public void setLatestTicketingTime(String latestTicketingTime) {
        this.latestTicketingTime = latestTicketingTime;
    }

    public String getPtc() {
        return ptc;
    }

    public void setPtc(String ptc) {
        this.ptc = ptc;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [baseFareTotal = " + baseFareTotal + ", passengers = " + passengers + ", saleFareTotal = " + saleFareTotal + ", tax = " + tax + ", saleTotal = " + saleTotal + ", fare = " + fare + ", segmentPricing = " + segmentPricing + ", fareCalculation = " + fareCalculation + ", saleTaxTotal = " + saleTaxTotal + ", latestTicketingTime = " + latestTicketingTime + ", ptc = " + ptc + ", kind = " + kind + "]";
    }
}