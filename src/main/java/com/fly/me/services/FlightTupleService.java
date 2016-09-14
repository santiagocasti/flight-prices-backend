package com.fly.me.services;

import com.fly.me.controllers.FlightPricesController;
import com.fly.me.dtos.pojos.Airport;
import com.fly.me.dtos.pojos.FlightTuple;
import com.fly.me.repositories.FlightTupleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class FlightTupleService {

    private final Logger logger = Logger.getLogger(FlightTupleService.class.toString());

    @Autowired
    FlightTupleRepository flightTupleRepository;

    public List<FlightTuple> getFor(Airport origin, Airport destination) {
        return flightTupleRepository.getAll(origin, destination);
    }

}
