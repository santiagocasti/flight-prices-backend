package com.fly.me.dtos.pojos;

public class GeneralTax {
    private String id;

    private String name;

    private String kind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", name = " + name + ", kind = " + kind + "]";
    }
}