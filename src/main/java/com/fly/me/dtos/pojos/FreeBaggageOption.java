package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.Frozen;
import com.datastax.driver.mapping.annotations.UDT;

import java.util.List;

@UDT(keyspace = "flights", name = "baggage_option")
public class FreeBaggageOption {
    private String kind;

    @Frozen("frozen<list<frozen<bag_descriptor>>>")
    private List<BagDescriptor> bagDescriptor;
    private Integer kilos;
    private Integer kilosPerPiece;
    private Integer pieces;
    private Integer pounds;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<BagDescriptor> getBagDescriptor() {
        return bagDescriptor;
    }

    public void setBagDescriptor(List<BagDescriptor> bagDescriptor) {
        this.bagDescriptor = bagDescriptor;
    }

    public Integer getKilos() {
        return kilos;
    }

    public void setKilos(Integer kilos) {
        this.kilos = kilos;
    }

    public Integer getKilosPerPiece() {
        return kilosPerPiece;
    }

    public void setKilosPerPiece(Integer kilosPerPiece) {
        this.kilosPerPiece = kilosPerPiece;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Integer getPounds() {
        return pounds;
    }

    public void setPounds(Integer pounds) {
        this.pounds = pounds;
    }
}
