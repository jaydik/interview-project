package com.adhawk.clients;

import com.adhawk.models.responses.apixu.CurrentWeatherResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.JerseyClientBuilder;

public class ApixuClient {

    private final String CURRENT_PATH = "current.json";
    private final String HISTORY_PATH = "history.json";
    private final String FORCAST_PATH = "current.json";

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

    public CurrentWeatherResponse getCurrentWeatherConditions(String query) {
        CurrentWeatherResponse currentWeatherResponse = target
                .path(CURRENT_PATH)
                .queryParam("key", key)
                .queryParam("q", query)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(CurrentWeatherResponse.class);

        return currentWeatherResponse;
    }

    public static void main(String[] args) {
        ApixuClient apixuClient = new ApixuClient("https://api.apixu.com/v1/", "c748320c28454a8a9a001636182606");

        apixuClient.getCurrentWeatherConditions("92101");

    }

}
