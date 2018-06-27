package com.adhawk.managers;

import com.adhawk.clients.ApixuClient;
import com.adhawk.models.CurrentTemperature;
import com.adhawk.models.responses.apixu.WeatherResponse;

public class WeatherManager {

    private ApixuClient apixuClient;

    public WeatherManager(ApixuClient apixuClient) {
        this.apixuClient = apixuClient;
    }

    public CurrentTemperature getCurrentTemperatureInFarenheit(String zipCode) {

        // lets make the assumption is valid zip for this project
        WeatherResponse currentWeatherResponse = apixuClient.getCurrentWeatherConditions(zipCode);

        CurrentTemperature currentTemperature = new CurrentTemperature();
        currentTemperature.setLocation(currentWeatherResponse.getLocation().getName() + ", "
                + currentWeatherResponse.getLocation().getRegion());
        currentTemperature.setTemperature(currentWeatherResponse.getCurrent().getTempF()+"");

        return currentTemperature;
    }
}
