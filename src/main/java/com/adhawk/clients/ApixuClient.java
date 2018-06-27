package com.adhawk.clients;

import com.adhawk.models.responses.apixu.WeatherResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.JerseyClientBuilder;

public class ApixuClient {

    private final String CURRENT_PATH = "current.json";
    private final String HISTORY_PATH = "history.json";
    private final String FORECAST_PATH = "forecast.json";

    private Client client;
    private WebTarget target;
    private String url;
    private String key;

    public ApixuClient(String url, String key) {
        client = new JerseyClientBuilder()
                .build();

        this.url = url;
        this.key = key;

        target = client.target(url);
    }

    public WeatherResponse getCurrentWeatherConditions(String query) {

        return target
                .path(CURRENT_PATH)
                .queryParam("key", key)
                .queryParam("q", query)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(WeatherResponse.class);
    }
}

