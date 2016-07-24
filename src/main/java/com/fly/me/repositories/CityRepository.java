package com.fly.me.repositories;

import com.fly.me.dtos.pojos.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepository {

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected final String tablenName = "city";

    public Boolean saveCity(City city) {
        this.validate(city);
        return cassandraRepository.insertJsonObject(tablenName, city);
    }

    public void validate(City c) {
        if (c.getCountry() == null) {
            c.setCountry("US");
        }

        if (c.getCode() == null) {
            c.setCode("-empty-");
        }
    }

}
