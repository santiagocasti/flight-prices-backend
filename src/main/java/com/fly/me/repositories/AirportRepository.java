package com.fly.me.repositories;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.fly.me.base.CassandraRepository;
import com.fly.me.base.accessors.AirportAccessor;
import com.fly.me.dtos.pojos.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class AirportRepository {

    protected final String tablenName = "airport";
    private final Logger logger = Logger.getLogger(AirportRepository.class.toString());
    @Autowired
    protected CassandraRepository cassandraRepository;

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

    public Airport get(String cityCode) {
        Session session = cassandraRepository.getSession();
        MappingManager manager = new MappingManager(session);

        AirportAccessor airportAccessor = manager.createAccessor(AirportAccessor.class);
        return airportAccessor.get(cityCode);
    }
}
