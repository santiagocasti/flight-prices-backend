package com.fly.me.services;

import com.fly.me.dtos.pojos.FlightSearchParameters;
import com.fly.me.dtos.pojos.SearchResponse;
import com.fly.me.dtos.pojos.qpx.QPXSearchParameters;
import com.fly.me.dtos.pojos.qpx.QPXSliceParameter;
import com.fly.me.services.qpx.GoogleQPXAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class FlightSearchService {

    @Autowired
    protected GoogleQPXAPIService googleQPXAPIService;

    @Autowired
    protected SearchResultsService searchResultsService;

    public int findFlights(FlightSearchParameters parameters) {
        QPXSearchParameters params = convertToQPXFormat(parameters);
        SearchResponse response = googleQPXAPIService.searchFlights(params);
        return searchResultsService.saveSearchResults(parameters, response);
    }

    protected QPXSearchParameters convertToQPXFormat(FlightSearchParameters parameters) {

        QPXSearchParameters params = new QPXSearchParameters();
        params.setAdultCount(parameters.getAdultCount());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");

        QPXSliceParameter slice = new QPXSliceParameter();
        slice.setOrigin(parameters.getOrigin());
        slice.setDestination(parameters.getDestination());
        slice.setDate(parameters.getFlightOutDate().format(formatter));
        slice.setMaxStops(0);
        params.addSlice(slice);

        if (parameters.isReturnFlight()) {
            slice = new QPXSliceParameter();
            slice.setOrigin(parameters.getDestination());
            slice.setDestination(parameters.getOrigin());
            slice.setDate(parameters.getFlightBackDate().format(formatter));
            slice.setMaxStops(0);
            params.addSlice(slice);
        }

        return params;
    }



}
