package com.bemal.prescription_app.Dto;

public class SingleDrugRequest {

    private String drugName;

    private Integer strength;

    private String drugStrengthUnit;

    private Integer dose;

    private String doseUnit;

    private String preparation;

    private String route;

    private String direction;

    private String frequency;

    private Integer duration;

    private String durationUnit;

    private Integer totalQuantity;

    private String otherInstructions;

    public SingleDrugRequest() {
    }

    public SingleDrugRequest(String drugName, Integer strength, String drugStrengthUnit, Integer dose, String doseUnit, String preparation, String route, String direction, String frequency, Integer duration, String durationUnit, Integer totalQuantity, String otherInstructions) {
        this.drugName = drugName;
        this.strength = strength;
        this.drugStrengthUnit = drugStrengthUnit;
        this.dose = dose;
        this.doseUnit = doseUnit;
        this.preparation = preparation;
        this.route = route;
        this.direction = direction;
        this.frequency = frequency;
        this.duration = duration;
        this.durationUnit = durationUnit;
        this.totalQuantity = totalQuantity;
        this.otherInstructions = otherInstructions;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public String getDrugStrengthUnit() {
        return drugStrengthUnit;
    }

    public void setDrugStrengthUnit(String drugStrengthUnit) {
        this.drugStrengthUnit = drugStrengthUnit;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public String getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getOtherInstructions() {
        return otherInstructions;
    }

    public void setOtherInstructions(String otherInstructions) {
        this.otherInstructions = otherInstructions;
    }
}
