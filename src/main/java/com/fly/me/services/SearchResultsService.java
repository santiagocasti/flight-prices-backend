package com.fly.me.services;

import com.fly.me.dtos.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class SearchResultsService {

    @Autowired
    protected AirportService airportService;

    @Autowired
    protected CityService cityService;

    @Autowired
    protected AircraftService aircraftService;

    @Autowired
    protected GeneralTaxService generalTaxService;

    @Autowired
    protected CarrierService carrierService;

    @Autowired
    protected TripOptionService tripOptionService;

    @Autowired
    protected ImportsService importsService;

    private static final Logger logger = Logger.getLogger(SearchResultsService.class.toString());

    public int saveSearchResults(SearchResponse res) {

        Trips trips = res.getTrips();
        if (trips == null) {
            logger.warning("No results to save in this SearchResponse.");
            return 0;
        }

        Data data = trips.getData();

        //airports
        Airport[] airports = data.getAirport();
        airportService.saveAirports(airports);

        //city
        City[] cities = data.getCity();
        cityService.saveCities(cities);

        //aircraft
        Aircraft[] aircrafts = data.getAircraft();
        aircraftService.saveAircrafts(aircrafts);

        //carrier
        Carrier[] carriers = data.getCarrier();
        carrierService.saveCarriers(carriers);

        //tax
        GeneralTax[] taxes = data.getTax();
        generalTaxService.saveGeneralTaxes(taxes);

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String date = dateFormat.format(now);
        String time = timeFormat.format(now);

        //trip options
        TripOption[] options = trips.getTripOption();
        tripOptionService.saveTripOptions(options, date, time);

        //record the import
        importsService.saveImport(date, time, options.length);

        return options.length;
    }

}
