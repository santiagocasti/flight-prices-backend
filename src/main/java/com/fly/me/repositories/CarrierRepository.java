package com.fly.me.repositories;

import com.fly.me.base.CassandraRepository;
import com.fly.me.dtos.pojos.Carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarrierRepository {

    protected final String tablenName = "carrier";
    @Autowired
    protected CassandraRepository cassandraRepository;

    public Boolean saveCarrier(Carrier carrier) {
        this.validate(carrier);
        return cassandraRepository.insertJsonObject(tablenName, carrier);
    }

    public void validate(Carrier c) {
        if (c.getCode() == null) {
            c.setCode("-empty-");
        }
    }

}
