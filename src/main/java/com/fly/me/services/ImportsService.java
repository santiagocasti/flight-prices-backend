package com.fly.me.services;

import com.fly.me.dtos.pojos.Import;
import com.fly.me.repositories.ImportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImportsService {

    @Autowired
    protected ImportsRepository importsRepository;

    public Boolean saveImport(String date, String time, int numImports) {

        Import importInstance = new Import();
        importInstance.setDate(date);
        importInstance.setTime(time);
        importInstance.setNumResults(numImports);

        return importsRepository.saveImport(importInstance);
    }

}
