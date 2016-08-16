package com.fly.me.repositories;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.fly.me.base.CassandraRepository;
import com.fly.me.dtos.pojos.OriginDestinationTuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class OriginDestinationTupleRepository extends BaseCassandraRepository {

    private final Logger logger = Logger.getLogger(OriginDestinationTupleRepository.class.toString());

    public Boolean validate(OriginDestinationTuple tuple) {

        if (tuple.getOriginAirportCode() == null ||
                tuple.getDestinationAirportCode() == null) {
            return false;
        }

        return true;
    }

    public Boolean save(OriginDestinationTuple tuple) {

        if (!this.validate(tuple)) {
            logger.warning("Couldn't save origin-destination tuple because some field was null: " + tuple.toString());
            return false;
        }

        MappingManager manager = getMappingManager();
        Mapper<OriginDestinationTuple> mapper = manager.mapper(OriginDestinationTuple.class);
        mapper.save(tuple);

        return true;
    }
}
