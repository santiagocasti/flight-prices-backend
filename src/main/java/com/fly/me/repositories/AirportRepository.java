package com.fly.me.repositories;

import com.fly.me.dtos.pojos.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AirportRepository {

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected final String tablenName = "airport";

    public void validate(Airport airport) {
        if (airport.getCity() == null) {
            airport.setCity("-empty-");
        }

        if (airport.getCode() == null) {
            airport.setCode("-empty-");
        }
    }

    public Boolean saveAirport(Airport airport) {
        this.validate(airport);
        return cassandraRepository.insertJsonObject(tablenName, airport);
    }

}
