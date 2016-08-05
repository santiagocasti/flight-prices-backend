package com.fly.me.base.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.fly.me.dtos.pojos.TripOption;

@Accessor
public interface TripOptionAccessor {
	@Query("SELECT * FROM trip_option WHERE date = ?")
	Result<TripOption> getForDate(String date);

	@Query("SELECT * FROM trip_option WHERE date = ? AND time = ? AND id = ?")
	TripOption getOne(String date, String time, String id);
}
