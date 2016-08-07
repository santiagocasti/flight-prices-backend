package com.fly.me.tasks;

import com.fly.me.controllers.ImportsController;
import com.fly.me.dtos.pojos.FlightSearchParameters;
import com.fly.me.services.FlightSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.logging.Logger;

@Component
public class ScheduledTask {

    protected static Logger logger = Logger.getLogger(ScheduledTask.class.toString());

    @Autowired
    protected ImportsController importsController;

    @Autowired
    protected FlightSearchService flightSearchService;

    /**
     * @Scheduled triggers a task based on its parameters.
     * In this case: @Scheduled(fixedRate = 5000), every 5 seconds.
     */
    @Scheduled(fixedRate = 1800000)
    public void triggerImport() {

        FlightSearchParameters params = new FlightSearchParameters();
        params.setAdultCount(1);
        params.setOrigin("BOS");
        params.setDestination("LAX");
        params.setFlightOutDate(LocalDate.of(2016, Month.NOVEMBER, 15));
        params.setFlightBackDate(LocalDate.of(2016, Month.NOVEMBER, 17));
        params.setReturnFlight(true);

        int flightCount = flightSearchService.findFlights(params);
        logger.info(String.format("We found %d flights at %s", flightCount, new Date().toString()));

    }
}
