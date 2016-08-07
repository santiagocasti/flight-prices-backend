package com.fly.me.dtos.pojos;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "flights", name = "origin_destination_tuple")
public class OriginDestinationTuple {

	@PartitionKey
	@Column(name = "origin_airport_code")
	private String originAirportCode;

	@ClusteringColumn(0)
	@Column(name = "destination_airport_code")
	private String destinationAirportCode;

	@Column(name = "origin_city_code")
	private String originCityCode;

	@Column(name = "destination_city_code")
	private String destinationCityCode;

	public String getOriginAirportCode() {
		return originAirportCode;
	}

	public void setOriginAirportCode(String originAirportCode) {
		this.originAirportCode = originAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public String getOriginCityCode() {
		return originCityCode;
	}

	public void setOriginCityCode(String originCityCode) {
		this.originCityCode = originCityCode;
	}

	public String getDestinationCityCode() {
		return destinationCityCode;
	}

	public void setDestinationCityCode(String destinationCityCode) {
		this.destinationCityCode = destinationCityCode;
	}
}
