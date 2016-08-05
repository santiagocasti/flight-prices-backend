package com.fly.me.repositories;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.fly.me.base.CassandraRepository;
import com.fly.me.base.accessors.TripOptionAccessor;
import com.fly.me.dtos.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class TripOptionRepository {

	@Autowired
	protected CassandraRepository cassandraRepository;

	protected final String tablenName = "trip_option";

	private final Logger logger = Logger.getLogger(TripOptionRepository.class.toString());

	public void validate(TripOption option) {
		if (option.getDate() == null || option.getTime() == null) {
			Date now = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			String date = dateFormat.format(now);
			String time = timeFormat.format(now);
			option.setDate(date);
			option.setTime(time);
		}
	}

	public Boolean saveTripOption(TripOption tripOption) {
		this.validate(tripOption);
		return cassandraRepository.insertJsonObject(tablenName, tripOption);
	}

	public TripOption getOne(String date, String time, String id) {

		if (date.isEmpty() || time.isEmpty() || id.isEmpty()) {
			logger.warning("Tried to retrieve a TripOption without complete primary key.");
			return null;
		}

		Session session = cassandraRepository.getSession();
		MappingManager manager = new MappingManager(session);
		manager.udtCodec(BagDescriptor.class);
		manager.udtCodec(Fare.class);
		manager.udtCodec(Flight.class);
		manager.udtCodec(FreeBaggageOption.class);
		manager.udtCodec(Leg.class);
		manager.udtCodec(Passengers.class);
		manager.udtCodec(Pricing.class);
		manager.udtCodec(Segment.class);
		manager.udtCodec(SegmentPricing.class);
		manager.udtCodec(Slice.class);
		manager.udtCodec(Tax.class);

		TripOptionAccessor tripOptionAccessor = manager.createAccessor(TripOptionAccessor.class);
		TripOption option = tripOptionAccessor.getOne(date, time, id);
		logger.info(String.format("[%s][%s] - [%s]", option.getDate(), option.getTime(), option.getSaleTotal()));

		return option;
	}

	public List<TripOption> getForDate(String date) {
		Session session = cassandraRepository.getSession();
		MappingManager manager = new MappingManager(session);
		manager.udtCodec(BagDescriptor.class);
		manager.udtCodec(Fare.class);
		manager.udtCodec(Flight.class);
		manager.udtCodec(FreeBaggageOption.class);
		manager.udtCodec(Leg.class);
		manager.udtCodec(Passengers.class);
		manager.udtCodec(Pricing.class);
		manager.udtCodec(Segment.class);
		manager.udtCodec(SegmentPricing.class);
		manager.udtCodec(Slice.class);
		manager.udtCodec(Tax.class);

		TripOptionAccessor tripOptionAccessor = manager.createAccessor(TripOptionAccessor.class);
		Result<TripOption> result = tripOptionAccessor.getForDate(date);

		for (TripOption option : result) {
			logger.info(String.format("[%s][%s] - [%s]", option.getDate(), option.getTime(), option.getSaleTotal()));
		}

		return result.all();

	}
}
