package com.fly.me.dtos.pojos;

public class Slice {
    private String duration;

    private Segment[] segment;

    private String kind;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Segment[] getSegment() {
        return segment;
    }

    public void setSegment(Segment[] segment) {
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