package com.fly.me.controllers;

import com.fly.me.repositories.ImportsRepository;
import net.minidev.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.HashMap;

@RestController
public class ImportsController {

    protected ImportsRepository importsRepository;

    @Autowired
    public ImportsController(ImportsRepository importsRepository) {
        this.importsRepository = importsRepository;
    }

    @RequestMapping("/imports")
    public
    @ResponseBody
    String runTest() {
        // TODO: must be an automated way of serializing
        HashMap<String, String> response = new HashMap<>();
        response.put("last_import_date", this.importsRepository.getLastImportDate().toString());

        System.out.println("Now trying the QPX request:");
//        this.prepareSimpleRequest();

        try{
            this.tryApacheHttpClient();
        }catch (Exception e){
            System.out.println("Shit happened!");
            System.out.println(e.getMessage());
        }

        return (new JSONObject(response)).toString();
    }


    public void tryApacheHttpClient(){
        String url = "https://www.googleapis.com/qpxExpress/v1/trips/search" + "?" + "key=" + "AIzaSyCvjuJ4p6UuXSIQ3_9JqfsEeGvTXr32Nuk";

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

        System.out.println("URL is: "+url);

        // add header
//        post.setHeader("User-Agent", USER_AGENT);
        post.setHeader("Content-Type", "application/json");

//        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//        urlParameters.add(new BasicNameValuePair("api_key", "AIzaSyCvjuJ4p6UuXSIQ3_9JqfsEeGvTXr32Nuk"));

        try{
            String body = "{ \"request\": { \"passengers\": { \"adultCount\": 1 }, \"slice\": [ { \"origin\": \"BOS\", \"destination\": \"LAX\", \"date\": \"2016-07-15\" }, { \"origin\": \"LAX\", \"destination\": \"BOS\", \"date\": \"2016-07-17\" } ] } }";
            System.out.println("body: "+body);
            post.setEntity(new StringEntity(body));

            HttpResponse response = client.execute(post);
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

//            StringBuffer result = new StringBuffer();

            String result = "";
            String line = "";
            while ((line = rd.readLine()) != null) {
//                System.out.println(line);
                result = result + line;
            }

            System.out.println(result);
//            JsonElement jelement = new JsonParser().parse(result);
//            JsonObject jobject = jelement.getAsJsonObject();
//            JsonObject dataObject = jobject.getAsJsonObject("data");
//            JsonArray airportsArray = dataObject.getAsJsonArray("airport");
//
//            for (JsonElement airport : airportsArray){
//                System.out.println("Airport: " + airport.toString());
//            }

        }catch (Exception e){
            System.out.println("Shit happened!");
            System.out.println(e.getMessage());
        }
    }
}
