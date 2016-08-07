package com.fly.me.repositories;

import com.datastax.driver.core.*;
import com.datastax.driver.mapping.MappingManager;
import com.datastax.driver.mapping.Result;
import com.fly.me.base.CassandraRepository;
import com.fly.me.base.accessors.ImportAccessor;
import com.fly.me.dtos.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Component
public class ImportsRepository {

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected final String tablenName = "import";

    private final Logger logger = Logger.getLogger(ImportsRepository.class.toString());

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

    public List<Import> getAll() {
        Session session = cassandraRepository.getSession();
        MappingManager manager = new MappingManager(session);

        ImportAccessor importAccessor = manager.createAccessor(ImportAccessor.class);
        Result<Import> result = importAccessor.getAll();

        List<Import> imports = new ArrayList<Import>();
        for (Import importInstance: result) {
            logger.info(String.format("[%s][%s] - [%d]", importInstance.getDate(), importInstance.getTime(), importInstance.getNumResults()));
            imports.add(importInstance);
        }

        logger.info("options.size() = "+imports.size());

        return imports;
    }
}