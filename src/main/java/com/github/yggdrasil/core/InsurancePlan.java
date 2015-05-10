package com.github.yggdrasil.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class InsurancePlan {

    /**
     * Plan ID
     */
    private long id;

    /**
     * Plan name
     * @example InsureCo HMO 6600
     */
    private String planName;

    /**
     * Insurer
     * @example InsureCo
     */
    private String insurer;

    /**
     * Monthly cost of insurance plan
     * @example 145.00
     */
    private double monthlyCost;

    /**
     * Yearly deductible of insurance plan
     * @example 6500.00
     */
    private double deductible;

    /**
     * List of insurance services offered
     * @see InsuranceService
     */
    private List<InsuranceService> services;

    /**
     * Grade of plan
     * @example Bronze
     */
    private String grade;

    public InsurancePlan() {}

    public InsurancePlan(long id, double deductible, String grade, String insurer, double monthlyCost, String planName, List<InsuranceService> services) {
        this.id = id;
        this.deductible = deductible;
        this.grade = grade;
        this.insurer = insurer;
        this.monthlyCost = monthlyCost;
        this.planName = planName;
        this.services = services;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public double getDeductible() {
        return deductible;
    }

    @JsonProperty
    public String getGrade() {
        return grade;
    }

    @JsonProperty
    public String getInsurer() {
        return insurer;
    }

    @JsonProperty
    public double getMonthlyCost() {
        return monthlyCost;
    }

    @JsonProperty
    public String getPlanName() {
        return planName;
    }

    public List<InsuranceService> getServices() {
        return services;
    }
}
