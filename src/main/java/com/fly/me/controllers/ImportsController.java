package com.fly.me.controllers;

import com.fly.me.repositories.ImportsRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ImportsController {

    protected ImportsRepository importsRepository;

    @Autowired
    public ImportsController(ImportsRepository importsRepository){
        this.importsRepository = importsRepository;
    }

    @RequestMapping("/imports")
    public @ResponseBody String runTest(){
        // TODO: must be an automated way of serializing
        HashMap<String, String> response = new HashMap<>();
        response.put("last_import_date", this.importsRepository.getLastImportDate().toString());
        return (new JSONObject(response)).toString();
    }
}
