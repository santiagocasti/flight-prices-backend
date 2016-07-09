package com.fly.me.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class ImportsRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ImportsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Timestamp getLastImportDate(){
        return this.jdbcTemplate.queryForObject("SELECT import_date FROM imports ORDER BY import_date DESC LIMIT 1", Timestamp.class);
    }

    public void recordNewImport(Date importDate){
        this.jdbcTemplate.update("INSERT INTO imports (id, import_date) VALUES (default, ?)", new Object[] {importDate});
    }

}