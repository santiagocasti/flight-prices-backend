package com.fly.me.repositories;

import com.fly.me.base.CassandraRepository;
import com.fly.me.dtos.pojos.GeneralTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GeneralTaxRepository {

    @Autowired
    protected CassandraRepository cassandraRepository;

    protected final String tablenName = "general_tax";

    public void validate(GeneralTax tax) {
        if (tax.getId() == null) {
            tax.setId("-empty-");
        }
    }

    public Boolean saveGeneralTax(GeneralTax tax) {
        this.validate(tax);
        return cassandraRepository.insertJsonObject(tablenName, tax);
    }

}
