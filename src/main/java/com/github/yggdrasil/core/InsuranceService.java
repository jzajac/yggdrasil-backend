package com.github.yggdrasil.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsuranceService {

    /**
     * Service Name
     * @example Doctor's Visits
     */
    private String name;

    /**
     * Service copay
     * @example "14.00" or "No copay if deductible is met"
     */
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
