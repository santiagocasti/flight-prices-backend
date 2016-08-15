package com.fly.me.base.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.fly.me.dtos.pojos.FlattenedTripOption;

@Accessor
public interface FlattenedTripOptionAccessor {
    @Query("SELECT * FROM flattened_trip_option WHERE flight_code = ?")
    Result<FlattenedTripOption> getAll(String flightCode);
}
