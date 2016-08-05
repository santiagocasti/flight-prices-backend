package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "flights", name = "segment")
public class Segment {
    private Integer bookingCodeCount;

    private String id;

    @Frozen("frozen<list<frozen<leg>>>")
    private List<Leg> leg;

    private String cabin;

    @Frozen("frozen<flight>")
    private Flight flight;

    private Integer duration;

    private String marriedSegmentGroup;

    private String kind;

    private String bookingCode;

    private Integer connectionDuration;

    private Boolean subjectToGovernmentApproval;

    public Integer getConnectionDuration() {
        return connectionDuration;
    }

    public void setConnectionDuration(Integer connectionDuration) {
        this.connectionDuration = connectionDuration;
    }

    public Boolean getSubjectToGovernmentApproval() {
        return subjectToGovernmentApproval;
    }

    public void setSubjectToGovernmentApproval(Boolean subjectToGovernmentApproval) {
        this.subjectToGovernmentApproval = subjectToGovernmentApproval;
    }

    public Integer getBookingCodeCount() {
        return bookingCodeCount;
    }

    public void setBookingCodeCount(Integer bookingCodeCount) {
        this.bookingCodeCount = bookingCodeCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Leg> getLeg() {
        return leg;
    }

    public void setLeg(List<Leg> leg) {
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
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