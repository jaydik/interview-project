package com.adhawk;

import com.codahale.metrics.health.HealthCheck;

public class TemperatureInsightsHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        final String saying = "Health Check";
        if (!saying.contains("Health")) {
            return Result.unhealthy("Uh Ohh");
        }
        return Result.healthy();
    }
}
