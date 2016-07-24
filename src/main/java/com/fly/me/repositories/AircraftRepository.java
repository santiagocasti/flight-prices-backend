package com.fly.me.repositories;

import com.fly.me.dtos.pojos.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AircraftRepository {

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected final String tablenName = "aircraft";

    public Boolean saveAircraft(Aircraft aircraft) {

        this.validate(aircraft);
        return cassandraRepository.insertJsonObject(tablenName, aircraft);
    }

    public void validate(Aircraft a) {
        if (a.getCode() == null) {
            a.setCode("-empty-");
        }
    }

}
