package com.fly.me.repositories;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.fly.me.base.CassandraRepository;
import com.fly.me.base.accessors.FlattenedTripOptionAccessor;
import com.fly.me.dtos.pojos.FlattenedTripOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class FlattenedTripOptionRepository {

    protected final String tablenName = "trip_option_flattened";
    private final Logger logger = Logger.getLogger(FlattenedTripOptionRepository.class.toString());
    @Autowired
    protected CassandraRepository cassandraRepository;

    public Boolean saveFlattenedTripOption(FlattenedTripOption tripOption) {

        MappingManager manager = new MappingManager(cassandraRepository.getSession());
        Mapper<FlattenedTripOption> mapper = manager.mapper(FlattenedTripOption.class);
        mapper.save(tripOption);

        return true;
    }

    public List<FlattenedTripOption> getPricesFor(
            String flightOutCode,
            String flightBackCode,
            LocalDate flightOutDate,
            LocalDate flightBackDate) {

        Session session = cassandraRepository.getSession();
        MappingManager manager = new MappingManager(session);

        FlattenedTripOptionAccessor flattenedTripOptionAccessor = manager.createAccessor(FlattenedTripOptionAccessor.class);
        Result<FlattenedTripOption> result = flattenedTripOptionAccessor.getAll(getFlightCode(flightOutCode, flightBackCode));

        List<FlattenedTripOption> options = new ArrayList<>();
        for (FlattenedTripOption option : result) {
            options.add(option);
        }

        return options;
    }

    protected String getFlightCode(String flightOutCode, String flightBackCode) {
        return flightOutCode + "-" + flightBackCode;
    }
}
