package com.fly.me.dtos.pojos;

public class Segment {
    private String bookingCodeCount;

    private String id;

    private Leg[] leg;

    private String cabin;

    private Flight flight;

    private String duration;

    private String marriedSegmentGroup;

    private String kind;

    private String bookingCode;

    private Integer connectionDuration;

    private String subjectToGovernmentApproval;

    public Integer getConnectionDuration() {
        return connectionDuration;
    }

    public void setConnectionDuration(Integer connectionDuration) {
        this.connectionDuration = connectionDuration;
    }

    public String getSubjectToGovernmentApproval() {
        return subjectToGovernmentApproval;
    }

    public void setSubjectToGovernmentApproval(String subjectToGovernmentApproval) {
        this.subjectToGovernmentApproval = subjectToGovernmentApproval;
    }

    public String getBookingCodeCount() {
        return bookingCodeCount;
    }

    public void setBookingCodeCount(String bookingCodeCount) {
        this.bookingCodeCount = bookingCodeCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Leg[] getLeg() {
        return leg;
    }

    public void setLeg(Leg[] leg) {
        this.leg = leg;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMarriedSegmentGroup() {
        return marriedSegmentGroup;
    }

    public void setMarriedSegmentGroup(String marriedSegmentGroup) {
        this.marriedSegmentGroup = marriedSegmentGroup;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    @Override
    public String toString() {
        return "ClassPojo [bookingCodeCount = " + bookingCodeCount + ", id = " + id + ", leg = " + leg + ", cabin = " + cabin + ", flight = " + flight + ", duration = " + duration + ", marriedSegmentGroup = " + marriedSegmentGroup + ", kind = " + kind + ", bookingCode = " + bookingCode + "]";
    }
}