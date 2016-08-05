package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "flights", name = "slice")
public class Slice {
    private Integer duration;

    @Frozen("frozen<list<segment>>")
    private List<Segment> segment;

    private String kind;

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<Segment> getSegment() {
        return segment;
    }

    public void setSegment(List<Segment> segment) {
        this.segment = segment;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [duration = " + duration + ", segment = " + segment + ", kind = " + kind + "]";
    }
}