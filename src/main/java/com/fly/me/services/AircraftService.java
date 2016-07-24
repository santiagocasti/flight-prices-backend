package com.fly.me.services;

import com.fly.me.dtos.pojos.Aircraft;
import com.fly.me.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {

    @Autowired
    protected AircraftRepository aircraftRepository;

    public Boolean saveAircrafts(Aircraft[] aircrafts) {

        for (Aircraft a : aircrafts) {
            aircraftRepository.saveAircraft(a);
        }

        return true;
    }

}
