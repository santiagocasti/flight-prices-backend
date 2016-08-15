package com.fly.me.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.dtos.pojos.FlightSearchParameters;
import com.fly.me.dtos.pojos.SearchResponse;
import com.fly.me.repositories.FlattenedTripOptionRepository;
import com.fly.me.repositories.FlightTupleRepository;
import com.fly.me.repositories.ImportsRepository;
import com.fly.me.repositories.OriginDestinationTupleRepository;
import com.fly.me.services.FlightSearchService;
import com.fly.me.services.SearchResultsService;
import com.fly.me.services.TripOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

@RestController
public class ImportsController {

    private final Logger logger = Logger.getLogger(ImportsController.class.toString());
    @Autowired
    protected ImportsRepository importsRepository;
    @Autowired
    protected FlightTupleRepository flightTupleRepository;
    @Autowired
    protected OriginDestinationTupleRepository originDestinationTupleRepository;
    @Autowired
    protected FlightSearchService flightSearchService;
    @Autowired
    protected SearchResultsService searchResultsService;
    @Autowired
    protected TripOptionService tripOptionService;
    @Autowired
    protected FlattenedTripOptionRepository flattenedTripOptionRepository;

    @RequestMapping("/imports")
    public
    @ResponseBody
    String imports() {
        try {
//            FlightSearchParameters params = new FlightSearchParameters();
//            params.setAdultCount(1);
//            params.setOrigin("BOS");
//            params.setDestination("LAX");
//            params.setFlightOutDate(LocalDate.of(2016, Month.NOVEMBER, 15));
//            params.setFlightBackDate(LocalDate.of(2016, Month.NOVEMBER, 17));
//            params.setReturnFlight(true);
//            flightSearchService.findFlights(params);

            this.fakeResponse();

        } catch (Exception e) {
            logger.info("Shit happened!");
            e.printStackTrace();
        }

        return "Yolo";
    }

    @RequestMapping("/stats")
    public
    @ResponseBody
    String stats() {

        //testing endpoint to try out code quickly

        return "Yolo2";
    }

    public void fakeResponse() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get("/Users/santiago/code/mvn-tutorial/project_2/backend/src/main/Resources/exampleResponse.json"));
        String result = new String(encoded, "UTF-8");

        logger.info("The size of result is: " + result.length());
        ObjectMapper mapper = new ObjectMapper();

        //JSON from String to Object
        SearchResponse searchResponse = mapper.readValue(result, SearchResponse.class);
        logger.info("Kind of object: " + searchResponse.getKind());

        FlightSearchParameters params = new FlightSearchParameters();
        params.setOrigin("BOS");
        params.setDestination("LAX");

        searchResultsService.saveSearchResults(params, searchResponse);
    }

}
