package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.UDT;

@UDT(keyspace = "flights", name = "tax")
public class Tax {
    private String id;

    private String salePrice;

    private String code;

    private String chargeType;

    private String kind;

    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", salePrice = " + salePrice + ", code = " + code + ", chargeType = " + chargeType + ", kind = " + kind + ", country = " + country + "]";
    }
}
