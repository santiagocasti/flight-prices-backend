package com.fly.me.services;

import com.fly.me.dtos.pojos.City;
import com.fly.me.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    protected CityRepository cityRepository;

    public Boolean saveCities(City[] cities) {

        for (City c : cities) {
            cityRepository.saveCity(c);
        }

        return true;
    }

}
