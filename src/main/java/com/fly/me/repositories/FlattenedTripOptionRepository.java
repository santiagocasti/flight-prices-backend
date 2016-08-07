package com.fly.me.repositories;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import com.fly.me.base.CassandraRepository;
import com.fly.me.dtos.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class FlattenedTripOptionRepository {

	@Autowired
	protected CassandraRepository cassandraRepository;

	protected final String tablenName = "trip_option_flattened";

	private final Logger logger = Logger.getLogger(FlattenedTripOptionRepository.class.toString());

	public Boolean saveFlattenedTripOption(FlattenedTripOption tripOption) {

		MappingManager manager = new MappingManager(cassandraRepository.getSession());
		Mapper<FlattenedTripOption> mapper = manager.mapper(FlattenedTripOption.class);
		mapper.save(tripOption);

		return true;
	}

}
