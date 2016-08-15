package com.fly.me.repositories;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.fly.me.base.CassandraRepository;
import com.fly.me.dtos.pojos.FlightTuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class FlightTupleRepository {

    private final Logger logger = Logger.getLogger(FlightTupleRepository.class.toString());
    @Autowired
    protected CassandraRepository cassandraRepository;

    public Boolean validate(FlightTuple tuple) {

        if (tuple.getFlightOutCode() == null ||
                tuple.getJourneyCode() == null ||
                tuple.getReturnFlightCode() == null) {
            return false;
        }

        return true;
    }

    public Boolean save(FlightTuple flightTuple) {

        if (!this.validate(flightTuple)) {
            logger.warning("Couldn't save flight tuple because some field was null: " + flightTuple.toString());
            return false;
        }

        MappingManager manager = new MappingManager(cassandraRepository.getSession());
        Mapper<FlightTuple> mapper = manager.mapper(FlightTuple.class);
        mapper.save(flightTuple);

        return true;
    }
}
