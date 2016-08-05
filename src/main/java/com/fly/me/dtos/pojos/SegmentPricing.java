package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "flights", name = "segment_pricing")
public class SegmentPricing {
    private String fareId;

    private String segmentId;

    private String kind;

    @Frozen("frozen<list<frozen<baggage_option>>>")
    private List<FreeBaggageOption> freeBaggageOption;

    public List<FreeBaggageOption> getFreeBaggageOption() {
        return freeBaggageOption;
    }

    public void setFreeBaggageOption(List<FreeBaggageOption> freeBaggageOption) {
        this.freeBaggageOption = freeBaggageOption;
    }

    public String getFareId() {
        return fareId;
    }

    public void setFareId(String fareId) {
        this.fareId = fareId;
    }

    public String getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(String segmentId) {
        this.segmentId = segmentId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [fareId = " + fareId + ", segmentId = " + segmentId + ", kind = " + kind + "]";
    }
}
