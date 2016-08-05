package com.fly.me.repositories;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.fly.me.base.CassandraRepository;
import com.fly.me.dtos.pojos.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ImportsRepository {

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected final String tablenName = "import";

    public Boolean saveImport(Import importInstance) {
        return cassandraRepository.insertJsonObject(tablenName, importInstance);
    }

    public Import getLastImportFrom(Date date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);

        PreparedStatement statement = cassandraRepository.getPreparedStatement("SELECT * FROM import WHERE date = ?");
        BoundStatement boundStatement = new BoundStatement(statement);
        boundStatement = boundStatement.bind(dateString);

        ResultSet resultSet = cassandraRepository.execute(boundStatement);

        List<Row> rows = resultSet.all();
        Row row = rows.get(rows.size() - 1);

        Import imp = new Import();
        imp.setNumResults(row.get("numresults", int.class));
        imp.setTime(row.get("time", String.class));
        imp.setDate(row.get("date", String.class));

        return imp;
    }
}