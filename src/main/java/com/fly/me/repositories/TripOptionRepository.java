package com.fly.me.repositories;

import com.fly.me.dtos.pojos.TripOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class TripOptionRepository {

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected final String tablenName = "trip_option";

    public void validate(TripOption option) {
        if (option.getDate() == null || option.getTime() == null) {
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String date = dateFormat.format(now);
            String time = timeFormat.format(now);
            option.setDate(date);
            option.setTime(time);
        }
    }

    public Boolean saveTripOption(TripOption tripOption) {
        this.validate(tripOption);
        return cassandraRepository.insertJsonObject(tablenName, tripOption);
    }

}
