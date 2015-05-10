package com.github.yggdrasil.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsuranceService {

    private String name;

    private String copay;

    public InsuranceService() {}

    public InsuranceService(String copay, String name) {
        this.copay = copay;
        this.name = name;
    }

    @JsonProperty
    public String getCopay() {
        return copay;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
}
