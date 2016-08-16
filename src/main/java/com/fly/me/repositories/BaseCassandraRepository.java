package com.fly.me.repositories;

import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import com.fly.me.base.CassandraRepository;
import org.springframework.beans.factory.annotation.Autowired;

abstract class BaseCassandraRepository {

    protected static MappingManager mappingManager;

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected MappingManager getMappingManager() {

        if (mappingManager != null) {
            return mappingManager;
        }

        Session session = cassandraRepository.getSession();
        mappingManager = new MappingManager(session);

        return mappingManager;
    }

}
