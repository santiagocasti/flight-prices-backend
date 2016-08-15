package com.fly.me.services;

import com.fly.me.dtos.pojos.FlattenedTripOption;
import com.fly.me.repositories.FlattenedTripOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightPricesService {

    @Autowired
    private FlattenedTripOptionRepository flattenedTripOptionRepository;

    public List<FlattenedTripOption> getOptions(
            String flightOutCode,
            String flightBackCode,
            LocalDate flightOutDate,
            LocalDate flightBackDate) {
        return flattenedTripOptionRepository.getPricesFor(flightOutCode, flightBackCode, flightOutDate, flightBackDate);
    }

}