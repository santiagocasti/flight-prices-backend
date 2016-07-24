package com.fly.me.services;

import com.fly.me.dtos.pojos.TripOption;
import com.fly.me.repositories.TripOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripOptionService {

    @Autowired
    protected TripOptionRepository tripOptionRepository;

    public Boolean saveTripOptions(TripOption[] trips, String date, String time) {

        for (TripOption trip : trips) {
            trip.setDate(date);
            trip.setTime(time);
            tripOptionRepository.saveTripOption(trip);
        }

        return true;
    }

}
