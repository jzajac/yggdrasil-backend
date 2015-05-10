package com.github.yggdrasil.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jzajac on 5/10/15.
 */
public class InsurancePlan {

    private long id;

    private String planName;

    private String insurer;

    private double monthlyCost;

    private double deductible;

    private List<InsuranceService> services;

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
