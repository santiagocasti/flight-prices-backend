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

    public int saveSearchResults(FlightSearchParameters searchParams, SearchResponse res) {

        Trips trips = res.getTrips();
        if (trips == null) {
            logger.warning("No results to save in this SearchResponse.");
            return 0;
        }

        // record the saving time, common for all records
        Date savingTime= new Date();

        Data data = trips.getData();

        saveAirports(data);
        saveCities(data);
        saveAircrafts(data);
        saveCarriers(data);
        saveGeneralTax(data);
        saveTripOptions(trips, savingTime, searchParams);

        //record the import
        importsService.saveImport(getDateString(savingTime), getTimeString(savingTime), trips.getTripOption().length);

        return trips.getTripOption().length;
    }

    public String getDateString(Date now){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(now);
    }

    public String getTimeString(Date now) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        return timeFormat.format(now);
    }

    public void saveAirports(Data data) {
        Airport[] airports = data.getAirport();
        if (airports.length > 0){
            airportService.saveAirports(airports);
        }
    }

    public void saveCities(Data data) {
        City[] cities = data.getCity();
        if (cities.length > 0) {
            cityService.saveCities(cities);
        }
    }

    public void saveAircrafts(Data data) {
        Aircraft[] aircrafts = data.getAircraft();
        if (aircrafts.length > 0) {
            aircraftService.saveAircrafts(aircrafts);
        }
    }

    public void saveCarriers(Data data) {
        Carrier[] carriers = data.getCarrier();
        if (carriers.length > 0) {
            carrierService.saveCarriers(carriers);
        }
    }

    public void saveGeneralTax(Data data) {
        GeneralTax[] taxes = data.getTax();
        if (taxes.length > 0) {
            generalTaxService.saveGeneralTaxes(taxes);
        }
    }

    public void saveTripOptions(Trips trips, Date savingTime, FlightSearchParameters searchParams) {
        TripOption[] options = trips.getTripOption();
        String date = getDateString(savingTime);
        String time = getTimeString(savingTime);
        for (TripOption option : options ) {
            option.setDate(date);
            option.setTime(time);
        }

        if (options.length > 0) {
            tripOptionService.saveTripOptions(options, searchParams);
        }
    }

}
