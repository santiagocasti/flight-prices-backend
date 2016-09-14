package com.fly.me.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.fly.me.Views.JacksonViews;
import com.fly.me.dtos.pojos.Airport;
import com.fly.me.dtos.pojos.FlattenedTripOption;
import com.fly.me.dtos.pojos.FlightTuple;
import com.fly.me.exceptions.EntityNotFound;
import com.fly.me.services.AirportService;
import com.fly.me.services.FlightPricesService;
import com.fly.me.services.FlightTupleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class FlightPricesController {

    private final Logger logger = Logger.getLogger(FlightPricesController.class.toString());

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightTupleService flightTupleService;

    @Autowired
    private FlightPricesService flightPricesService;

    @RequestMapping("/flight-tuples")
    @JsonView(JacksonViews.FlightTuple.Basic.class)
    public
    @ResponseBody
    List<FlightTuple> getFlightTuplesFor(
            @RequestParam(value = "originCity", defaultValue = "BOS") String originCity,
            @RequestParam(value = "destinationCity", defaultValue = "LAX") String destinationCity) {

        Airport originAirport = airportService.getOne(originCity);

        if (originAirport == null) {
            logger.warning("Throwing exception, airport not found: " + originCity);
            throw new EntityNotFound("Airport", originCity);
        }

        Airport destinationAirport = airportService.getOne(destinationCity);
        if (destinationAirport == null) {
            throw new EntityNotFound("Airport", destinationCity);
        }

        return flightTupleService.getFor(originAirport, destinationAirport);
    }

    @RequestMapping("/flight-prices")
    @JsonView(JacksonViews.FlattenedTripOption.PriceList.class)
    public
    @ResponseBody
    List<FlattenedTripOption> getFlightPricesFor(
            @RequestParam(value = "flightOutCode", defaultValue = "B6287") String flightOutCode,
            @RequestParam(value = "flightBackCode", defaultValue = "B6488") String flightBackCode,
            @RequestParam(value = "flightOutDate", defaultValue = "2016-11-15") String flightOut,
            @RequestParam(value = "flightBackDate", defaultValue = "2016-11-17") String flightBack
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate flightOutDate = LocalDate.parse(flightOut, formatter);
        LocalDate flightBackDate = LocalDate.parse(flightBack, formatter);

        return flightPricesService.getOptions(flightOutCode, flightBackCode, flightOutDate, flightBackDate);
    }

}
