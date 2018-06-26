package com.adhawk.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ServiceConfiguration extends Configuration {

    @JsonProperty("db")
    private DBConfiguration dbConfiguration;

    public DBConfiguration getDbConfiguration() {
        return dbConfiguration;
    }

    public void setDbConfiguration(DBConfiguration dbConfiguration) {
        this.dbConfiguration = dbConfiguration;
    }

    @JsonProperty("clients")
    private ClientConfiguration clientConfiguration;

    public ClientConfiguration getClientConfiguration() {
        return clientConfiguration;
    }

    public void setClientConfiguration(ClientConfiguration clientConfiguration) {
        this.clientConfiguration = clientConfiguration;
    }
}
