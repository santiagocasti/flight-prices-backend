CREATE KEYSPACE
 flights
WITH
 replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

USE flights;

CREATE TABLE airport (
  kind text,
  city text,
  code text,
  name text,
  PRIMARY KEY (city, code)
);

CREATE TABLE city (
  kind text,
  country text,
  code text,
  name text,
  PRIMARY KEY (country, code)
);

CREATE TABLE aircraft (
  kind text,
  code text PRIMARY KEY,
  name text
);

CREATE TABLE carrier (
  kind text,
  code text PRIMARY KEY,
  name text
);

CREATE TABLE general_tax (
  kind text,
  id text PRIMARY KEY,
  name text
);

CREATE TYPE flight (
  carrier text,
  number text
);

CREATE TYPE leg (
  kind text,
  id text,
  aircraft text,
  arrivalTime text,
  departureTime text,
  origin text,
  destination text,
  originTerminal text,
  destinationTerminal text,
  duration int,
  operatingDisclosure text,
  onTimePerformance int,
  mileage int,
  meal text,
  secure boolean,
  connectionDuration int,
  changePlane boolean
);

CREATE TYPE segment (
  kind text,
  duration int,
  flight frozen<flight>,
  id text,
  cabin text,
  bookingCode text,
  bookingCodeCount int,
  marriedSegmentGroup text,
  subjectToGovernmentApproval boolean,
  leg frozen<list<leg>>,
  connectionDuration int
);

CREATE TYPE fare (
  kind text,
  id text,
  carrier text,
  origin text,
  destination text,
  basisCode text,
  private boolean
);

CREATE TYPE passengers (
  kind text,
  adultCount int,
  childCount int,
  infantInLapCount int,
  infantInSeatCount int,
  seniorCount int
);

CREATE TYPE tax (
  kind text,
  id text,
  chargeType text,
  code text,
  country text,
  salePrice text
);

CREATE TYPE bag_descriptor (
  kind text,
  commercialName text,
  count int,
  description list<text>,
  subcode text
);

CREATE TYPE baggage_option (
  kind text,
  bagDescriptor frozen<list<bag_descriptor>>,
  kilos int,
  kilosPerPiece int,
  pieces int,
  pounds int
);

CREATE TYPE segment_pricing (
  kind text,
  fareId text,
  segmentId text,
  freeBaggageOption frozen<list<baggage_option>>,
);

CREATE TYPE pricing (
  kind text,
  fare frozen<list<fare>>,
  segmentPricing frozen<list<segment_pricing>>,
  baseFareTotal text,
  saleFareTotal text,
  saleTaxTotal text,
  saleTotal text,
  passengers frozen<passengers>,
  tax frozen<list<tax>>,
  fareCalculation text,
  latestTicketingTime text,
  ptc text,
  refundable boolean
);

CREATE TYPE slice (
  kind text,
  duration int,
  segment frozen<list<segment>>,
);

CREATE TABLE import (
  date text,
  time text,
  numResults int,
  PRIMARY KEY (date, time)
);

CREATE TABLE trip_option (
  kind text,
  saleTotal text,
  id text,
  slice frozen<list<slice>>,
  pricing frozen<list<pricing>>,
  date text,
  time text,
  PRIMARY KEY (date, time, id)
);

CREATE TABLE flattened_trip_option (
  flight_code text,
  date text,
  time text,
  price float,
  id text,
  flight_code_out text,
  flight_code_return text,
  currency text,
  PRIMARY KEY (flight_code, date, time, price)
);

CREATE TABLE origin_destination_tuple (
  origin_city_code text,
  origin_airport_code text,
  destination_city_code text,
  destination_airport_code text,
  PRIMARY KEY (origin_airport_code, destination_airport_code)
);

CREATE TABLE flight_tuples_by_journey (
  journey_code text,
  flight_out_code text,
  return_flight_code text,
  PRIMARY KEY (journey_code, flight_out_code, return_flight_code)
);


-- copy trip_option to '2016-08-04_trip_option.backup' ;






































