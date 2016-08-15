package com.fly.me.base.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.fly.me.dtos.pojos.FlightTuple;

@Accessor
public interface FlightTupleAccessor {
    @Query("SELECT * FROM flight_tuples_by_journey WHERE journey_code = ?")
    Result<FlightTuple> getAll(String journeyCode);

}