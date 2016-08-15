package com.fly.me.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.dtos.pojos.Airport;
import com.fly.me.dtos.pojos.FlattenedTripOption;
import com.fly.me.dtos.pojos.FlightTuple;
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
public class FlightPricesAPI {

    private final Logger logger = Logger.getLogger(FlightPricesAPI.class.toString());

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightTupleService flightTupleService;

    @Autowired
    private FlightPricesService flightPricesService;

    @RequestMapping("/flight-tuples")
    public
    @ResponseBody
    String getFlightTuplesFor(
            @RequestParam(value = "originCity", defaultValue = "BOS") String originCity,
            @RequestParam(value = "destinationCity", defaultValue = "LAX") String destinationCity) {

        Airport originAirport = airportService.getOne(originCity);

        if (originAirport == null) {
            return "{error: 'cannot find origin airport'}";
        }

        Airport destinationAirport = airportService.getOne(destinationCity);
        if (destinationAirport == null) {
            return "{error: 'cannot find destination airport'}";
        }

        List<FlightTuple> tuples = flightTupleService.getFor(originAirport, destinationAirport);

        ObjectMapper mapper = new ObjectMapper();

        String jsonInString;
        try {
            jsonInString = mapper.writeValueAsString(tuples);
        } catch (JsonProcessingException e) {
            String message = String.format("Couldn't create JSON response for List<FlightTuple> for origin [%s] and destination [%s].", originCity, destinationCity);
            jsonInString = "{ error : '"+message+"' }";
            logger.severe(message);
        }

        return jsonInString;
    }

    @RequestMapping("/flight-prices")
    public @ResponseBody String getFlightPricesFor(
            @RequestParam(value = "flightOutCode", defaultValue = "B6287") String flightOutCode,
            @RequestParam(value = "flightBackCode", defaultValue = "B6488") String flightBackCode,
            @RequestParam(value = "flightOutDate", defaultValue = "2016-11-15") String flightOut,
            @RequestParam(value = "flightBackDate", defaultValue = "2016-11-17") String flightBack
    ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate flightOutDate = LocalDate.parse(flightOut, formatter);
        LocalDate flightBackDate = LocalDate.parse(flightBack, formatter);

        List<FlattenedTripOption> prices = flightPricesService.getOptions(flightOutCode, flightBackCode, flightOutDate, flightBackDate);

        ObjectMapper mapper = new ObjectMapper();

        String jsonInString;
        try {
            jsonInString = mapper.writeValueAsString(prices);
        } catch (JsonProcessingException e) {
            String message = String.format("Couldn't create JSON response for List<FlattenedTripOption> for flightOut [%s] and flightBack [%s].", flightOutCode, flightBackCode);
            jsonInString = "{ error : '"+message+"' }";
            logger.severe(message);
        }

        return jsonInString;

    }

}
