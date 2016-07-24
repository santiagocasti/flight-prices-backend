package com.fly.me.services;

import com.fly.me.dtos.pojos.GeneralTax;
import com.fly.me.repositories.GeneralTaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralTaxService {

    @Autowired
    protected GeneralTaxRepository generalTaxRepository;

    public Boolean saveGeneralTaxes(GeneralTax[] taxes) {

        for (GeneralTax tax : taxes) {
            generalTaxRepository.saveGeneralTax(tax);
        }

        return true;
    }

}
