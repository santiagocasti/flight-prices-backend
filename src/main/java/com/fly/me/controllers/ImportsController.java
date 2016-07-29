package com.fly.me.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.dtos.pojos.FlightSearchParameters;
import com.fly.me.dtos.pojos.SearchResponse;
import com.fly.me.repositories.ImportsRepository;
import com.fly.me.services.FlightSearchService;
import com.fly.me.services.SearchResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;

@RestController
public class ImportsController {

    @Autowired
    protected ImportsRepository importsRepository;

    @Autowired
    protected FlightSearchService flightSearchService;

    @Autowired
    protected SearchResultsService searchResultsService;

    private final Logger logger = Logger.getLogger(ImportsController.class.toString());

    @RequestMapping("/imports")
    public
    @ResponseBody
    String imports() {
        try {
            FlightSearchParameters params = new FlightSearchParameters();
            params.setAdultCount(1);
            params.setOrigin("BOS");
            params.setDestination("LAX");
            params.setFlightOutDate(LocalDate.of(2016, Month.NOVEMBER, 15));
            params.setFlightBackDate(LocalDate.of(2016, Month.NOVEMBER, 17));
            params.setReturnFlight(true);
            flightSearchService.findFlights(params);

//            this.fakeResponse();

        } catch (Exception e) {
            logger.info("Shit happened!");
            e.printStackTrace();
        }

        return "Yolo";
    }

    public void fakeResponse() throws IOException {
        String result = RESPONSE;
        logger.info("The size of result is: " + result.length());
        ObjectMapper mapper = new ObjectMapper();

        //JSON from String to Object
        SearchResponse searchResponse = mapper.readValue(result, SearchResponse.class);
        logger.info("Kind of object: " + searchResponse.getKind());

        searchResultsService.saveSearchResults(searchResponse);
    }


    protected String RESPONSE = "{\n" +
            " \"kind\": \"qpxExpress#tripsSearch\",\n" +
            " \"trips\": {\n" +
            "  \"kind\": \"qpxexpress#tripOptions\",\n" +
            "  \"requestId\": \"7KUWUbV3cL18q91Ca0OjVK\",\n" +
            "  \"data\": {\n" +
            "   \"kind\": \"qpxexpress#data\",\n" +
            "   \"airport\": [\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#airportData\",\n" +
            "     \"code\": \"BOS\",\n" +
            "     \"city\": \"BOS\",\n" +
            "     \"name\": \"Boston Edward L. Logan International\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#airportData\",\n" +
            "     \"code\": \"LAX\",\n" +
            "     \"city\": \"LAX\",\n" +
            "     \"name\": \"Los Angeles International\"\n" +
            "    }\n" +
            "   ],\n" +
            "   \"city\": [\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#cityData\",\n" +
            "     \"code\": \"BOS\",\n" +
            "     \"name\": \"Boston\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#cityData\",\n" +
            "     \"code\": \"LAX\",\n" +
            "     \"name\": \"Los Angeles\"\n" +
            "    }\n" +
            "   ],\n" +
            "   \"aircraft\": [\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#aircraftData\",\n" +
            "     \"code\": \"320\",\n" +
            "     \"name\": \"Airbus A320\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#aircraftData\",\n" +
            "     \"code\": \"32S\",\n" +
            "     \"name\": \"Airbus A320\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#aircraftData\",\n" +
            "     \"code\": \"738\",\n" +
            "     \"name\": \"Boeing 737\"\n" +
            "    }\n" +
            "   ],\n" +
            "   \"tax\": [\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#taxData\",\n" +
            "     \"id\": \"ZP\",\n" +
            "     \"name\": \"US Flight Segment Tax\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#taxData\",\n" +
            "     \"id\": \"AY_001\",\n" +
            "     \"name\": \"US September 11th Security Fee\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#taxData\",\n" +
            "     \"id\": \"US_001\",\n" +
            "     \"name\": \"US Transportation Tax\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#taxData\",\n" +
            "     \"id\": \"XF\",\n" +
            "     \"name\": \"US Passenger Facility Charge\"\n" +
            "    }\n" +
            "   ],\n" +
            "   \"carrier\": [\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#carrierData\",\n" +
            "     \"code\": \"B6\",\n" +
            "     \"name\": \"Jetblue Airways Corporation\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#carrierData\",\n" +
            "     \"code\": \"UA\",\n" +
            "     \"name\": \"United Airlines, Inc.\"\n" +
            "    },\n" +
            "    {\n" +
            "     \"kind\": \"qpxexpress#carrierData\",\n" +
            "     \"code\": \"VX\",\n" +
            "     \"name\": \"Virgin America Inc.\"\n" +
            "    }\n" +
            "   ]\n" +
            "  },\n" +
            "  \"tripOption\": [\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD319.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN002\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 396,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 396,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"687\"\n" +
            "        },\n" +
            "        \"id\": \"GG2MCVfWMxBmWHqM\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"L8rN6tt6hPrpgjME\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T23:46-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T20:10-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 396,\n" +
            "          \"onTimePerformance\": 70,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 315,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 315,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"288\"\n" +
            "        },\n" +
            "        \"id\": \"GnfZOKIMmxAr4koW\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"O\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LxAkTmazujR72dvI\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-17T15:45-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T07:30-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 315,\n" +
            "          \"onTimePerformance\": 90,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"OH4QBSN5\",\n" +
            "        \"private\": true\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"segmentId\": \"GnfZOKIMmxAr4koW\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"GG2MCVfWMxBmWHqM\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD270.70\",\n" +
            "      \"saleFareTotal\": \"USD270.70\",\n" +
            "      \"saleTaxTotal\": \"USD48.50\",\n" +
            "      \"saleTotal\": \"USD319.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD20.30\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 162.79OH4QBSN5 USD 270.70 END ZP BOS LAX XT 20.30US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD319.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN006\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 397,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 397,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"487\"\n" +
            "        },\n" +
            "        \"id\": \"G7GqHh0mNNGf0cU7\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LKlzoHoqiDH9G0Rn\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T20:57-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T17:20-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 397,\n" +
            "          \"onTimePerformance\": 80,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 318,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 318,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"488\"\n" +
            "        },\n" +
            "        \"id\": \"GVHaYwLPm7uTzTG0\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"O\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LiJzAb7FtNjNlw9Q\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-17T20:01-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T11:43-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 318,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"OH4QBSN5\",\n" +
            "        \"private\": true\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"G7GqHh0mNNGf0cU7\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"segmentId\": \"GVHaYwLPm7uTzTG0\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD270.70\",\n" +
            "      \"saleFareTotal\": \"USD270.70\",\n" +
            "      \"saleTaxTotal\": \"USD48.50\",\n" +
            "      \"saleTotal\": \"USD319.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD20.30\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 162.79OH4QBSN5 USD 270.70 END ZP BOS LAX XT 20.30US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD319.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN003\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 393,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 393,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"287\"\n" +
            "        },\n" +
            "        \"id\": \"GcFtxxZt5vdSKO-q\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LOHbDfJT5J895VrW\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-15T10:33-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T07:00-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 393,\n" +
            "          \"onTimePerformance\": 90,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 318,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 318,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"488\"\n" +
            "        },\n" +
            "        \"id\": \"GVHaYwLPm7uTzTG0\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"O\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LiJzAb7FtNjNlw9Q\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-17T20:01-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T11:43-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 318,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"OH4QBSN5\",\n" +
            "        \"private\": true\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"GcFtxxZt5vdSKO-q\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"segmentId\": \"GVHaYwLPm7uTzTG0\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD270.70\",\n" +
            "      \"saleFareTotal\": \"USD270.70\",\n" +
            "      \"saleTaxTotal\": \"USD48.50\",\n" +
            "      \"saleTotal\": \"USD319.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD20.30\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 162.79OH4QBSN5 USD 270.70 END ZP BOS LAX XT 20.30US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD319.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN001\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 393,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 393,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"287\"\n" +
            "        },\n" +
            "        \"id\": \"GcFtxxZt5vdSKO-q\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LOHbDfJT5J895VrW\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-15T10:33-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T07:00-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 393,\n" +
            "          \"onTimePerformance\": 90,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 315,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 315,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"288\"\n" +
            "        },\n" +
            "        \"id\": \"GnfZOKIMmxAr4koW\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"O\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LxAkTmazujR72dvI\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-17T15:45-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T07:30-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 315,\n" +
            "          \"onTimePerformance\": 90,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"OH4QBSN5\",\n" +
            "        \"private\": true\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"GcFtxxZt5vdSKO-q\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"segmentId\": \"GnfZOKIMmxAr4koW\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD270.70\",\n" +
            "      \"saleFareTotal\": \"USD270.70\",\n" +
            "      \"saleTaxTotal\": \"USD48.50\",\n" +
            "      \"saleTotal\": \"USD319.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD20.30\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 162.79OH4QBSN5 USD 270.70 END ZP BOS LAX XT 20.30US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD319.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN005\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 396,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 396,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"687\"\n" +
            "        },\n" +
            "        \"id\": \"GG2MCVfWMxBmWHqM\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"L8rN6tt6hPrpgjME\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T23:46-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T20:10-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 396,\n" +
            "          \"onTimePerformance\": 70,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 318,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 318,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"488\"\n" +
            "        },\n" +
            "        \"id\": \"GVHaYwLPm7uTzTG0\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"O\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LiJzAb7FtNjNlw9Q\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-17T20:01-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T11:43-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 318,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"OH4QBSN5\",\n" +
            "        \"private\": true\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"GG2MCVfWMxBmWHqM\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"segmentId\": \"GVHaYwLPm7uTzTG0\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD270.70\",\n" +
            "      \"saleFareTotal\": \"USD270.70\",\n" +
            "      \"saleTaxTotal\": \"USD48.50\",\n" +
            "      \"saleTotal\": \"USD319.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD20.30\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 162.79OH4QBSN5 USD 270.70 END ZP BOS LAX XT 20.30US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD319.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN004\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 397,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 397,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"487\"\n" +
            "        },\n" +
            "        \"id\": \"G7GqHh0mNNGf0cU7\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LKlzoHoqiDH9G0Rn\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T20:57-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T17:20-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 397,\n" +
            "          \"onTimePerformance\": 80,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 315,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 315,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"288\"\n" +
            "        },\n" +
            "        \"id\": \"GnfZOKIMmxAr4koW\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"O\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LxAkTmazujR72dvI\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-17T15:45-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T07:30-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 315,\n" +
            "          \"onTimePerformance\": 90,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"OH4QBSN5\",\n" +
            "        \"private\": true\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"G7GqHh0mNNGf0cU7\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AgbduoZyktwKZQumbrUsU3pg5z6M/9RjyTgc3dgc32c2gsOcEtlPFOLtZx78gGnDg3qaAm/8uTpd0pmKjJXLNOKCczFNq4+u1kUIov0gRSeGS1O/8SyQay/PJCRwS/WgJVy/BrzyEG30yEo\",\n" +
            "        \"segmentId\": \"GnfZOKIMmxAr4koW\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD270.70\",\n" +
            "      \"saleFareTotal\": \"USD270.70\",\n" +
            "      \"saleTaxTotal\": \"USD48.50\",\n" +
            "      \"saleTotal\": \"USD319.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD20.30\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 162.79OH4QBSN5 USD 270.70 END ZP BOS LAX XT 20.30US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD346.21\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN00C\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 397,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 397,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"487\"\n" +
            "        },\n" +
            "        \"id\": \"G7GqHh0mNNGf0cU7\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LKlzoHoqiDH9G0Rn\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T20:57-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T17:20-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 397,\n" +
            "          \"onTimePerformance\": 80,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 316,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 316,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"688\"\n" +
            "        },\n" +
            "        \"id\": \"Gg04msQPA9R9rT0g\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"Z\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LXwWjPAoEfBnjdhe\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-18T06:05-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T21:49-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 316,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AHQmC06Z10qGyWEwJqz6cJH64Bo6kzrNvt5/Mmxwh+/w\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"ZH4ABEN\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AHQmC06Z10qGyWEwJqz6cJH64Bo6kzrNvt5/Mmxwh+/w\",\n" +
            "        \"segmentId\": \"Gg04msQPA9R9rT0g\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"G7GqHh0mNNGf0cU7\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD295.82\",\n" +
            "      \"saleFareTotal\": \"USD295.82\",\n" +
            "      \"saleTaxTotal\": \"USD50.39\",\n" +
            "      \"saleTotal\": \"USD346.21\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD22.19\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 187.91ZH4ABEN USD 295.82 END ZP BOS LAX XT 22.19US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD346.21\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN009\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 393,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 393,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"287\"\n" +
            "        },\n" +
            "        \"id\": \"GcFtxxZt5vdSKO-q\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LOHbDfJT5J895VrW\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-15T10:33-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T07:00-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 393,\n" +
            "          \"onTimePerformance\": 90,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 316,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 316,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"688\"\n" +
            "        },\n" +
            "        \"id\": \"Gg04msQPA9R9rT0g\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"Z\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LXwWjPAoEfBnjdhe\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-18T06:05-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T21:49-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 316,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AHQmC06Z10qGyWEwJqz6cJH64Bo6kzrNvt5/Mmxwh+/w\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"ZH4ABEN\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AHQmC06Z10qGyWEwJqz6cJH64Bo6kzrNvt5/Mmxwh+/w\",\n" +
            "        \"segmentId\": \"Gg04msQPA9R9rT0g\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"GcFtxxZt5vdSKO-q\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD295.82\",\n" +
            "      \"saleFareTotal\": \"USD295.82\",\n" +
            "      \"saleTaxTotal\": \"USD50.39\",\n" +
            "      \"saleTotal\": \"USD346.21\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD22.19\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 187.91ZH4ABEN USD 295.82 END ZP BOS LAX XT 22.19US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD346.21\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN00B\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 396,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 396,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"687\"\n" +
            "        },\n" +
            "        \"id\": \"GG2MCVfWMxBmWHqM\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"P\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"L8rN6tt6hPrpgjME\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T23:46-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T20:10-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"C\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 396,\n" +
            "          \"onTimePerformance\": 70,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 316,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 316,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"B6\",\n" +
            "         \"number\": \"688\"\n" +
            "        },\n" +
            "        \"id\": \"Gg04msQPA9R9rT0g\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"Z\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LXwWjPAoEfBnjdhe\",\n" +
            "          \"aircraft\": \"32S\",\n" +
            "          \"arrivalTime\": \"2016-11-18T06:05-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T21:49-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"C\",\n" +
            "          \"duration\": 316,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Meal\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"PI2ABEN5\",\n" +
            "        \"private\": true\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AHQmC06Z10qGyWEwJqz6cJH64Bo6kzrNvt5/Mmxwh+/w\",\n" +
            "        \"carrier\": \"B6\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"ZH4ABEN\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AHQmC06Z10qGyWEwJqz6cJH64Bo6kzrNvt5/Mmxwh+/w\",\n" +
            "        \"segmentId\": \"Gg04msQPA9R9rT0g\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AtqC6+VgsXRulMbdGTeSvUeBRnKb3x4mvOCn+mjZpKyuQ4AW9lO/+IsqwaxH0msbvoqAr187hH145K8Lzh5ESjzPOYFqksYTah9udaLlQ2Mo5heDN+Y8LuBuUUgMJkFZIDESDxLqz0Sa+O/\",\n" +
            "        \"segmentId\": \"GG2MCVfWMxBmWHqM\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD295.82\",\n" +
            "      \"saleFareTotal\": \"USD295.82\",\n" +
            "      \"saleTaxTotal\": \"USD50.39\",\n" +
            "      \"saleTotal\": \"USD346.21\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD22.19\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS B6 LAX 107.91PI2ABEN5 B6 BOS 187.91ZH4ABEN USD 295.82 END ZP BOS LAX XT 22.19US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD366.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN007\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 390,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 390,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"VX\",\n" +
            "         \"number\": \"367\"\n" +
            "        },\n" +
            "        \"id\": \"Ghesx-yapznBCa8B\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"N\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LfIXqHQMP0JUfocf\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T21:15-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T17:45-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"B\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 390,\n" +
            "          \"onTimePerformance\": 65,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 320,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 320,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"VX\",\n" +
            "         \"number\": \"360\"\n" +
            "        },\n" +
            "        \"id\": \"Gan6QDMZHomr2u3-\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"L\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LudrAUzgQpcrNNPb\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-17T16:50-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T08:30-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"B\",\n" +
            "          \"duration\": 320,\n" +
            "          \"onTimePerformance\": 81,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AY95sdE/wv6fa2JPyq1y0x6SnH7HeY1b2MlPXtm/1UxU\",\n" +
            "        \"carrier\": \"VX\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"N21NR\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"ADk56491qEm8AhaGBDWmI1qGisAQzgjamarRlAIcsgxc+\",\n" +
            "        \"carrier\": \"VX\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"L14QNR\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"ADk56491qEm8AhaGBDWmI1qGisAQzgjamarRlAIcsgxc+\",\n" +
            "        \"segmentId\": \"Gan6QDMZHomr2u3-\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AY95sdE/wv6fa2JPyq1y0x6SnH7HeY1b2MlPXtm/1UxU\",\n" +
            "        \"segmentId\": \"Ghesx-yapznBCa8B\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD314.42\",\n" +
            "      \"saleFareTotal\": \"USD314.42\",\n" +
            "      \"saleTaxTotal\": \"USD51.78\",\n" +
            "      \"saleTotal\": \"USD366.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD23.58\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS VX LAX 107.91N21NR VX BOS 206.51L14QNR USD 314.42 END ZP BOS LAX XT 23.58US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD366.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN008\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 390,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 390,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"VX\",\n" +
            "         \"number\": \"363\"\n" +
            "        },\n" +
            "        \"id\": \"GIM13d1KmhGzyK2h\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"N\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LUwcXTQDGqRCfsAJ\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T12:30-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T09:00-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"B\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 390,\n" +
            "          \"onTimePerformance\": 95,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 320,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 320,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"VX\",\n" +
            "         \"number\": \"360\"\n" +
            "        },\n" +
            "        \"id\": \"Gan6QDMZHomr2u3-\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"L\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LudrAUzgQpcrNNPb\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-17T16:50-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T08:30-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"B\",\n" +
            "          \"duration\": 320,\n" +
            "          \"onTimePerformance\": 81,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AY95sdE/wv6fa2JPyq1y0x6SnH7HeY1b2MlPXtm/1UxU\",\n" +
            "        \"carrier\": \"VX\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"N21NR\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"ADk56491qEm8AhaGBDWmI1qGisAQzgjamarRlAIcsgxc+\",\n" +
            "        \"carrier\": \"VX\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"L14QNR\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"ADk56491qEm8AhaGBDWmI1qGisAQzgjamarRlAIcsgxc+\",\n" +
            "        \"segmentId\": \"Gan6QDMZHomr2u3-\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AY95sdE/wv6fa2JPyq1y0x6SnH7HeY1b2MlPXtm/1UxU\",\n" +
            "        \"segmentId\": \"GIM13d1KmhGzyK2h\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD314.42\",\n" +
            "      \"saleFareTotal\": \"USD314.42\",\n" +
            "      \"saleTaxTotal\": \"USD51.78\",\n" +
            "      \"saleTotal\": \"USD366.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD23.58\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS VX LAX 107.91N21NR VX BOS 206.51L14QNR USD 314.42 END ZP BOS LAX XT 23.58US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD366.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN00E\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 390,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 390,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"VX\",\n" +
            "         \"number\": \"363\"\n" +
            "        },\n" +
            "        \"id\": \"GIM13d1KmhGzyK2h\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"N\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LUwcXTQDGqRCfsAJ\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T12:30-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T09:00-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"B\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 390,\n" +
            "          \"onTimePerformance\": 95,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 320,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 320,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"VX\",\n" +
            "         \"number\": \"370\"\n" +
            "        },\n" +
            "        \"id\": \"GGGAoWruvGpMYu6i\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"L\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LzAN99lumHDfh6Tw\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-18T07:45-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T23:25-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"B\",\n" +
            "          \"duration\": 320,\n" +
            "          \"onTimePerformance\": 65,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AY95sdE/wv6fa2JPyq1y0x6SnH7HeY1b2MlPXtm/1UxU\",\n" +
            "        \"carrier\": \"VX\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"N21NR\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"ADk56491qEm8AhaGBDWmI1qGisAQzgjamarRlAIcsgxc+\",\n" +
            "        \"carrier\": \"VX\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"L14QNR\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AY95sdE/wv6fa2JPyq1y0x6SnH7HeY1b2MlPXtm/1UxU\",\n" +
            "        \"segmentId\": \"GIM13d1KmhGzyK2h\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"ADk56491qEm8AhaGBDWmI1qGisAQzgjamarRlAIcsgxc+\",\n" +
            "        \"segmentId\": \"GGGAoWruvGpMYu6i\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD314.42\",\n" +
            "      \"saleFareTotal\": \"USD314.42\",\n" +
            "      \"saleTaxTotal\": \"USD51.78\",\n" +
            "      \"saleTotal\": \"USD366.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD23.58\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS VX LAX 107.91N21NR VX BOS 206.51L14QNR USD 314.42 END ZP BOS LAX XT 23.58US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD366.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN00D\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 390,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 390,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"VX\",\n" +
            "         \"number\": \"367\"\n" +
            "        },\n" +
            "        \"id\": \"Ghesx-yapznBCa8B\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"N\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LfIXqHQMP0JUfocf\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-15T21:15-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T17:45-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"B\",\n" +
            "          \"destinationTerminal\": \"3\",\n" +
            "          \"duration\": 390,\n" +
            "          \"onTimePerformance\": 65,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 320,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 320,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"VX\",\n" +
            "         \"number\": \"370\"\n" +
            "        },\n" +
            "        \"id\": \"GGGAoWruvGpMYu6i\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"L\",\n" +
            "        \"bookingCodeCount\": 7,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LzAN99lumHDfh6Tw\",\n" +
            "          \"aircraft\": \"320\",\n" +
            "          \"arrivalTime\": \"2016-11-18T07:45-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T23:25-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"3\",\n" +
            "          \"destinationTerminal\": \"B\",\n" +
            "          \"duration\": 320,\n" +
            "          \"onTimePerformance\": 65,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AY95sdE/wv6fa2JPyq1y0x6SnH7HeY1b2MlPXtm/1UxU\",\n" +
            "        \"carrier\": \"VX\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"N21NR\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"ADk56491qEm8AhaGBDWmI1qGisAQzgjamarRlAIcsgxc+\",\n" +
            "        \"carrier\": \"VX\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"L14QNR\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AY95sdE/wv6fa2JPyq1y0x6SnH7HeY1b2MlPXtm/1UxU\",\n" +
            "        \"segmentId\": \"Ghesx-yapznBCa8B\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"ADk56491qEm8AhaGBDWmI1qGisAQzgjamarRlAIcsgxc+\",\n" +
            "        \"segmentId\": \"GGGAoWruvGpMYu6i\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD314.42\",\n" +
            "      \"saleFareTotal\": \"USD314.42\",\n" +
            "      \"saleTaxTotal\": \"USD51.78\",\n" +
            "      \"saleTotal\": \"USD366.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD23.58\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS VX LAX 107.91N21NR VX BOS 206.51L14QNR USD 314.42 END ZP BOS LAX XT 23.58US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   },\n" +
            "   {\n" +
            "    \"kind\": \"qpxexpress#tripOption\",\n" +
            "    \"saleTotal\": \"USD389.20\",\n" +
            "    \"id\": \"JwyWqfLmahRSdnRrB0URsN00A\",\n" +
            "    \"slice\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 380,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 380,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"UA\",\n" +
            "         \"number\": \"717\"\n" +
            "        },\n" +
            "        \"id\": \"GNDwMRZSNFtBTtwJ\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"G\",\n" +
            "        \"bookingCodeCount\": 9,\n" +
            "        \"marriedSegmentGroup\": \"0\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LoD1Cc5I8Q9oZs7o\",\n" +
            "          \"aircraft\": \"738\",\n" +
            "          \"arrivalTime\": \"2016-11-15T21:40-08:00\",\n" +
            "          \"departureTime\": \"2016-11-15T18:20-05:00\",\n" +
            "          \"origin\": \"BOS\",\n" +
            "          \"destination\": \"LAX\",\n" +
            "          \"originTerminal\": \"B\",\n" +
            "          \"destinationTerminal\": \"7\",\n" +
            "          \"duration\": 380,\n" +
            "          \"onTimePerformance\": 80,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Food for Purchase\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     },\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#sliceInfo\",\n" +
            "      \"duration\": 323,\n" +
            "      \"segment\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentInfo\",\n" +
            "        \"duration\": 323,\n" +
            "        \"flight\": {\n" +
            "         \"carrier\": \"UA\",\n" +
            "         \"number\": \"824\"\n" +
            "        },\n" +
            "        \"id\": \"GuWMBJK2RGhnvlNk\",\n" +
            "        \"cabin\": \"COACH\",\n" +
            "        \"bookingCode\": \"S\",\n" +
            "        \"bookingCodeCount\": 9,\n" +
            "        \"marriedSegmentGroup\": \"1\",\n" +
            "        \"leg\": [\n" +
            "         {\n" +
            "          \"kind\": \"qpxexpress#legInfo\",\n" +
            "          \"id\": \"LB4o0MApE9mkbEXb\",\n" +
            "          \"aircraft\": \"738\",\n" +
            "          \"arrivalTime\": \"2016-11-17T17:08-05:00\",\n" +
            "          \"departureTime\": \"2016-11-17T08:45-08:00\",\n" +
            "          \"origin\": \"LAX\",\n" +
            "          \"destination\": \"BOS\",\n" +
            "          \"originTerminal\": \"7\",\n" +
            "          \"destinationTerminal\": \"B\",\n" +
            "          \"duration\": 323,\n" +
            "          \"mileage\": 2604,\n" +
            "          \"meal\": \"Food for Purchase\",\n" +
            "          \"secure\": true\n" +
            "         }\n" +
            "        ]\n" +
            "       }\n" +
            "      ]\n" +
            "     }\n" +
            "    ],\n" +
            "    \"pricing\": [\n" +
            "     {\n" +
            "      \"kind\": \"qpxexpress#pricingInfo\",\n" +
            "      \"fare\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"A/CJI0QVTZS5Se5kqZxIG5RoNxU/KlZdUuHsMthrPUpM\",\n" +
            "        \"carrier\": \"UA\",\n" +
            "        \"origin\": \"BOS\",\n" +
            "        \"destination\": \"LAX\",\n" +
            "        \"basisCode\": \"GAA21AHS\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#fareInfo\",\n" +
            "        \"id\": \"AYGpEap7GRG65zH2Rlu6blzwqDCw2afftmqNgGDv+67w\",\n" +
            "        \"carrier\": \"UA\",\n" +
            "        \"origin\": \"LAX\",\n" +
            "        \"destination\": \"BOS\",\n" +
            "        \"basisCode\": \"SAA00AHN\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"segmentPricing\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"AYGpEap7GRG65zH2Rlu6blzwqDCw2afftmqNgGDv+67w\",\n" +
            "        \"segmentId\": \"GuWMBJK2RGhnvlNk\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#segmentPricing\",\n" +
            "        \"fareId\": \"A/CJI0QVTZS5Se5kqZxIG5RoNxU/KlZdUuHsMthrPUpM\",\n" +
            "        \"segmentId\": \"GNDwMRZSNFtBTtwJ\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"baseFareTotal\": \"USD335.82\",\n" +
            "      \"saleFareTotal\": \"USD335.82\",\n" +
            "      \"saleTaxTotal\": \"USD53.38\",\n" +
            "      \"saleTotal\": \"USD389.20\",\n" +
            "      \"passengers\": {\n" +
            "       \"kind\": \"qpxexpress#passengerCounts\",\n" +
            "       \"adultCount\": 1\n" +
            "      },\n" +
            "      \"tax\": [\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"US_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"US\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD25.18\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"AY_001\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"AY\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD11.20\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"XF\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"XF\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD9.00\"\n" +
            "       },\n" +
            "       {\n" +
            "        \"kind\": \"qpxexpress#taxInfo\",\n" +
            "        \"id\": \"ZP\",\n" +
            "        \"chargeType\": \"GOVERNMENT\",\n" +
            "        \"code\": \"ZP\",\n" +
            "        \"country\": \"US\",\n" +
            "        \"salePrice\": \"USD8.00\"\n" +
            "       }\n" +
            "      ],\n" +
            "      \"fareCalculation\": \"BOS UA LAX 107.91GAA21AHS UA BOS 227.91SAA00AHN USD 335.82 END ZP BOS LAX XT 25.18US 8.00ZP 11.20AY 9.00XF BOS4.50 LAX4.50\",\n" +
            "      \"latestTicketingTime\": \"2016-07-20T23:59-04:00\",\n" +
            "      \"ptc\": \"ADT\"\n" +
            "     }\n" +
            "    ]\n" +
            "   }\n" +
            "  ]\n" +
            " }\n" +
            "}\n";

}
