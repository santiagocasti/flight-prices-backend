package com.fly.me.repositories;

import com.fly.me.dtos.pojos.Import;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportsRepository {

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected final String tablenName = "import";

    public Boolean saveImport(Import importInstance) {
        return cassandraRepository.insertJsonObject(tablenName, importInstance);
    }

}