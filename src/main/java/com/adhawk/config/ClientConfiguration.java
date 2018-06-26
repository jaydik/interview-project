package com.adhawk.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientConfiguration {

    @JsonProperty("apixu")
    private ApixuConfiguration apixuConfiguration;

    public ApixuConfiguration getApixuConfiguration() {
        return apixuConfiguration;
    }

    public void setApixuConfiguration(ApixuConfiguration apixuConfiguration) {
        this.apixuConfiguration = apixuConfiguration;
    }
}
