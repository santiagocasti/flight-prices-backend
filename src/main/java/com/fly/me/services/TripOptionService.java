package com.fly.me.services;

import com.fly.me.dtos.pojos.*;
import com.fly.me.repositories.FlattenedTripOptionRepository;
import com.fly.me.repositories.FlightTupleRepository;
import com.fly.me.repositories.OriginDestinationTupleRepository;
import com.fly.me.repositories.TripOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TripOptionService {

    private static final Logger logger = Logger.getLogger(TripOptionService.class.toString());
    @Autowired
    protected TripOptionRepository tripOptionRepository;
    @Autowired
    protected FlightTupleRepository flightTupleRepository;
    @Autowired
    protected OriginDestinationTupleRepository originDestinationTupleRepository;
    @Autowired
    protected FlattenedTripOptionRepository flattenedTripOptionRepository;

    public List<TripOption> getAll(String date) {
        return tripOptionRepository.getForDate(date);
    }

    public Boolean saveTripOptions(TripOption[] trips, FlightSearchParameters parameters) {

        for (TripOption trip : trips) {
            tripOptionRepository.saveTripOption(trip);
            saveDenormalisedVersions(trip, parameters);
        }

        return true;
    }

    public void saveDenormalisedVersions(TripOption option, FlightSearchParameters parameters) {

        FlattenedTripOption fto = new FlattenedTripOption();
        fto.setDate(option.getDate());
        fto.setTime(option.getTime());
        fto.setId(option.getId());
        String saleTotal = option.getSaleTotal();
        fto.setCurrency(saleTotal.substring(0, 2));
        Float price = Float.valueOf(saleTotal.substring(3, saleTotal.length()));
        fto.setPrice(price);

        List<Slice> slices = option.getSlice();
        if (slices.size() != 2) {
            logger.warning("Wrong number of slices for: " + option.toString());
            return;
        }

        String origin = parameters.getOrigin();
        String destination = parameters.getDestination();

        List<Segment> segments = slices.get(0).getSegment();
        String carrier1, number1, carrier2, number2, flightCode, flightOutCode = "", returnFlightCode = "";

        carrier1 = segments.get(0).getFlight().getCarrier();
        number1 = segments.get(0).getFlight().getNumber();

        String flightOrigin, flightDestination;

        flightOrigin = segments.get(0).getLeg().get(0).getOrigin();
        flightDestination = segments.get(0).getLeg().get(0).getDestination();

        logger.info(String.format("1 - [%s] [%s]", flightOrigin, flightDestination));

        if (origin.equals(segments.get(0).getLeg().get(0).getOrigin())) {
            fto.setFlightCodeThere(carrier1 + number1);
            flightOutCode = carrier1 + number1;
        } else {
            fto.setFlightCodeBack(carrier1 + number1);
            returnFlightCode = carrier1 + number1;
        }

        segments = slices.get(1).getSegment();
        carrier2 = segments.get(0).getFlight().getCarrier();
        number2 = segments.get(0).getFlight().getNumber();

        flightOrigin = segments.get(0).getLeg().get(0).getOrigin();
        flightDestination = segments.get(0).getLeg().get(0).getDestination();

        logger.info(String.format("2 - [%s] [%s]", flightOrigin, flightDestination));

        if (destination.equals(segments.get(0).getLeg().get(0).getOrigin())) {
            fto.setFlightCodeBack(carrier2 + number2);
            returnFlightCode = carrier2 + number2;
        } else {
            fto.setFlightCodeThere(carrier2 + number2);
            flightOutCode = carrier2 + number2;
        }

        logger.info(String.format("X - [%s] [%s]", flightOutCode, returnFlightCode));

        flightCode = flightOutCode + "-" + returnFlightCode;
        fto.setFlightCode(flightCode);

        flattenedTripOptionRepository.saveFlattenedTripOption(fto);

        FlightTuple flightTuple = new FlightTuple();
        flightTuple.setJourneyCode(origin + "-" + destination);
        flightTuple.setFlightOutCode(flightOutCode);
        flightTuple.setReturnFlightCode(returnFlightCode);
        flightTupleRepository.save(flightTuple);

        OriginDestinationTuple tuple = new OriginDestinationTuple();
        tuple.setOriginCityCode(origin);
        tuple.setOriginAirportCode(origin);
        tuple.setDestinationCityCode(destination);
        tuple.setDestinationAirportCode(destination);
        originDestinationTupleRepository.save(tuple);

    }

}
