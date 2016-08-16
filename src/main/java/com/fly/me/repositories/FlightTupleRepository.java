package com.fly.me.repositories;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.fly.me.base.CassandraRepository;
import com.fly.me.base.accessors.FlightTupleAccessor;
import com.fly.me.base.accessors.ImportAccessor;
import com.fly.me.dtos.pojos.Airport;
import com.fly.me.dtos.pojos.FlightTuple;
import com.fly.me.dtos.pojos.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class FlightTupleRepository extends BaseCassandraRepository {

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

        MappingManager manager = getMappingManager();
        Mapper<FlightTuple> mapper = manager.mapper(FlightTuple.class);
        mapper.save(flightTuple);

        return true;
    }

    public String getJourneyCode(Airport origin, Airport destination) {
        return (origin.getCode() + "-" + destination.getCode());
    }

    public List<FlightTuple> getAll(Airport origin, Airport destination) {
        MappingManager manager = getMappingManager();

        FlightTupleAccessor flightTupleAccessor= manager.createAccessor(FlightTupleAccessor.class);
        Result<FlightTuple> result = flightTupleAccessor.getAll(getJourneyCode(origin, destination));

        List<FlightTuple> tuples = new ArrayList<>();
        for (FlightTuple tuple : result) {
            tuples.add(tuple);
        }

        logger.info("options.size() = " + tuples.size());

        return tuples;
    }
}
