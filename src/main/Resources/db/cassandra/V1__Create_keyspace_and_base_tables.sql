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

-- definition of flight type

--check
CREATE TYPE flight (
  carrier text,
  number text
);

-- definition of leg type

--check
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

-- definition of segment type: includes flight and leg

--check
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

--check
CREATE TYPE fare (
  kind text,
  id text,
  carrier text,
  origin text,
  destination text,
  basisCode text,
  private boolean
);

--check
CREATE TYPE passengers (
  kind text,
  adultCount int,
  childCount int,
  infantInLapCount int,
  infantInSeatCount int,
  seniorCount int
);

--check
CREATE TYPE tax (
  kind text,
  id text,
  chargeType text,
  code text,
  country text,
  salePrice text
);

--check
CREATE TYPE bag_descriptor (
  kind text,
  commercialName text,
  count int,
  description set<text>,
  subcode text
);

-- check
CREATE TYPE baggage_option (
  kind text,
  bagDescriptor frozen<set<bag_descriptor>>,
  kilos int,
  kilosPerPiece int,
  pieces int,
  pounds int
);

--check
CREATE TYPE segment_pricing (
  kind text,
  fareId text,
  segmentId text,
  freeBaggageOption frozen<set<baggage_option>>,
);

--check
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

--checkCREATE TABLE import (
  date text,
  time text,
  numResults int,
  PRIMARY KEY (date, time)
)
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

















--
-- CREATE TYPE address(
--   street text,
--   number text
-- );
--
-- CREATE TYPE people (
--   first text,
--   middle text,
--   last text,
--   address frozen<address>
-- );
-- CREATE TABLE names (
--   id uuid PRIMARY KEY,
--   name frozen<people>
-- );
--
-- INSERT INTO
--   names (id, name)
-- VALUES (
--   now(),
--   {
--     first: 'santiago',
--     middle: 'julian',
--     last: 'castineira',
--     address: {
--       street: 'Isartalstr.',
--       number: '45A'
--     },
--     magorcho: {
--       one: '1'
--     }
--   }
-- );










































