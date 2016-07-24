package com.fly.me.services;

import com.fly.me.dtos.pojos.Airport;
import com.fly.me.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    @Autowired
    protected AirportRepository airportRepository;

    public Boolean saveAirports(Airport[] airports) {

        for (Airport a : airports) {
            airportRepository.saveAirport(a);
        }

        return true;
    }

}
