package com.adhawk.resource;

import com.adhawk.managers.WeatherManager;
import com.adhawk.models.CurrentTemperature;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

@Path("/weather")
@Produces(MediaType.APPLICATION_JSON)
public class WeatherResource {

    private WeatherManager weatherManager;

    public WeatherResource(WeatherManager weatherManager) {
        this.weatherManager = weatherManager;
    }

    @GET
    @Path("/current/{zipCode}")
    public CurrentTemperature getCurrentWeatherInFahrenheit(@PathParam("zipCode") String zipCode) {
        try {
            return weatherManager.getCurrentTemperatureInFarenheit(zipCode);
        } catch (Throwable th) {
            throw new WebApplicationException(INTERNAL_SERVER_ERROR);
        }
    }
}
