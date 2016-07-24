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
  leg frozen<set<leg>>,
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
  description set<text>,
  subcode text
);

CREATE TYPE baggage_option (
  kind text,
  bagDescriptor frozen<set<bag_descriptor>>,
  kilos int,
  kilosPerPiece int,
  pieces int,
  pounds int
);

CREATE TYPE segment_pricing (
  kind text,
  fareId text,
  segmentId text,
  freeBaggageOption frozen<set<baggage_option>>,
);

CREATE TYPE pricing (
  kind text,
  fare frozen<set<fare>>,
  segmentPricing frozen<set<segment_pricing>>,
  baseFareTotal text,
  saleFareTotal text,
  saleTaxTotal text,
  saleTotal text,
  passengers frozen<passengers>,
  tax frozen<set<tax>>,
  fareCalculation text,
  latestTicketingTime text,
  ptc text,
  refundable boolean
);

CREATE TYPE slice (
  kind text,
  duration int,
  segment frozen<set<segment>>,
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
  slice frozen<set<slice>>,
  pricing frozen<set<pricing>>,
  date text,
  time text,
  PRIMARY KEY (date, time, id)
);










































