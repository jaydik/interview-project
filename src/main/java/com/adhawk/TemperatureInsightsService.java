package com.adhawk;

import com.adhawk.clients.ApixuClient;
import com.adhawk.config.ServiceConfiguration;
import com.adhawk.managers.WeatherManager;
import com.adhawk.resource.TestResource;
import com.adhawk.resource.WeatherResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TemperatureInsightsService extends Application<ServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new TemperatureInsightsService().run(args);
    }

    @Override
    public String getName() {
        return "temperature-insights-service";
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ServiceConfiguration configuration,
                    Environment environment) {
        final TemperatureInsightsHealthCheck healthCheck = new TemperatureInsightsHealthCheck();

        //clients
        ApixuClient apixuClient = new ApixuClient(
                configuration.getClientConfiguration().getApixuConfiguration().getUrl(),
                configuration.getClientConfiguration().getApixuConfiguration().getKey());

        //Managers
        WeatherManager weatherManager = new WeatherManager(apixuClient);

        //resources
        WeatherResource weatherResource = new WeatherResource(weatherManager);
        TestResource testResource = new TestResource();

        environment.healthChecks().register("temperature-insights-service", healthCheck);

        environment.jersey().register(testResource);
        environment.jersey().register(weatherResource);
    }

}
