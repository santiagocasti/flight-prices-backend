package com.fly.me.base.accessors;

import com.datastax.driver.mapping.Result;
import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Query;
import com.fly.me.dtos.pojos.Import;

@Accessor
public interface ImportAccessor {
	@Query("SELECT * FROM import WHERE date = ?")
	Result<Import> getForDate(String date);

	@Query("SELECT * FROM import WHERE date = ? AND time = ?")
	Import getOne(String date, String time);

	@Query("SELECT * FROM import")
	Result<Import> getAll();
}
