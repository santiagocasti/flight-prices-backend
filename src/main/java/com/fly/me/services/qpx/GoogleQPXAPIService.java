package com.fly.me.services.qpx;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fly.me.dtos.pojos.SearchResponse;
import com.fly.me.dtos.pojos.qpx.QPXSearchParameters;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class GoogleQPXAPIService {

    private static final Logger logger = Logger.getLogger(GoogleQPXAPIService.class.toString());

    private static final String API_KEY = "AIzaSyCvjuJ4p6UuXSIQ3_9JqfsEeGvTXr32Nuk";

    public SearchResponse searchFlights(QPXSearchParameters params) {

        HttpClient client = HttpClientBuilder.create().build();
        String url = getUrl();
        logger.info("URL: "+url);
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");

        String jsonBody = getRequestBody(params);
        logger.info("JSON body for request: " + jsonBody);

        SearchResponse searchResponse = null;

        try {
            post.setEntity(new StringEntity(jsonBody));

            HttpResponse response = client.execute(post);
            int statusCode = response.getStatusLine().getStatusCode();
            logger.info("Response Code : "
                    + statusCode);

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            logger.info("The size of result is: " + result.length());

            if (statusCode == 200){
                ObjectMapper mapper = new ObjectMapper();
                //JSON from String to Object
                searchResponse = mapper.readValue(result, SearchResponse.class);
                logger.info("Kind of object: " + searchResponse.getKind());
            }else{
                logger.info("Request failed [" + statusCode + "] and the response was:");
                logger.info(result);
            }

        } catch (IOException exc){
            logger.warning("Scheiße happened :)");
            logger.info(exc.getMessage());
            for (StackTraceElement el : exc.getStackTrace()) {
                logger.info(el.toString());
            }
        } finally {
            if (searchResponse == null) {
                searchResponse = new SearchResponse();
            }
        }

        return searchResponse;
    }

    protected String getRequestBody(QPXSearchParameters parameters) {

        JsonNode result;
        try {
            result = parameters.toJSON();
        } catch (IOException e) {
            logger.warning("IOException occurred while turning searh parameters into JSON.");
            StackTraceElement[] trace = e.getStackTrace();
            for (StackTraceElement elem : trace) {
                logger.warning(elem.toString());
            }
            return "";
        }

        return result.toString();
    }

    protected String getUrl() {
        return "https://www.googleapis.com/qpxExpress/v1/trips/search" + "?" + "key=" + API_KEY;
    }

}
