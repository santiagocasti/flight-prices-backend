package com.fly.me.services;

import com.fly.me.dtos.pojos.Carrier;
import com.fly.me.repositories.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrierService {

    @Autowired
    protected CarrierRepository carrierRepository;

    public Boolean saveCarriers(Carrier[] carriers) {

        for (Carrier carrier : carriers) {
            carrierRepository.saveCarrier(carrier);
        }

        return true;
    }

}
