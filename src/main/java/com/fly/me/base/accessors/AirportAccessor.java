package com.fly.me.base.accessors;

import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.fly.me.dtos.pojos.Airport;

@Accessor
public interface AirportAccessor {
    @Query("SELECT * FROM airport WHERE city = ? LIMIT 1")
    Airport get(String city);

}
