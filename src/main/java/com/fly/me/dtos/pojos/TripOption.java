package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.List;

@Table( keyspace = "flights", name = "trip_option")
public class TripOption {

    @PartitionKey
    private String date;

    @ClusteringColumn(0)
    private String time;

    @ClusteringColumn(1)
    private String id;

    @Frozen("frozen<list<frozen<pricing>>>")
    private List<Pricing> pricing;

    private String saleTotal;

    @Frozen("frozen<list<frozen<slice>>>")
    private List<Slice> slice;

    private String kind;

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

    public List<Pricing> getPricing() {
        return pricing;
    }

    public void setPricing(List<Pricing> pricing) {
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

    public List<Slice> getSlice() {
        return slice;
    }

    public void setSlice(List<Slice> slice) {
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
