package com.bemal.prescription_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "drug")
public class Drug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "strength")
    private Integer strength;

    @ManyToOne
    @JoinColumn(name = "strength_unit_id")
    private DrugStrengthUnit drugStrengthUnit;

    @Column(name = "dose")
    private Integer dose;

    @ManyToOne
    @JoinColumn(name = "dose_unit_id")
    private DoseUnit doseUnit;

    @ManyToOne
    @JoinColumn(name = "preparation_id")
    private Preparation preparation;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;

    @ManyToOne
    @JoinColumn(name = "frequency_id")
    private Frequency frequency;

    @Column(name = "duration", nullable = true)
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "duration_unit_id")
    private DurationUnit durationUnit;

    @Column(name = "total_quantity", nullable = true)
    private Integer totalQuantity;

    @Column(name = "other_instructions", columnDefinition = "TEXT", nullable = true)
    private String otherInstructions;

    public Drug() {
    }

    public Drug(Long id, Prescription prescription, String drugName, Integer strength, DrugStrengthUnit drugStrengthUnit, Integer dose, DoseUnit doseUnit, Preparation preparation, Route route, Direction direction, Frequency frequency, Integer duration, DurationUnit durationUnit, Integer totalQuantity, String otherInstructions) {
        this.id = id;
        this.prescription = prescription;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
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

    public DrugStrengthUnit getDrugStrengthUnit() {
        return drugStrengthUnit;
    }

    public void setDrugStrengthUnit(DrugStrengthUnit drugStrengthUnit) {
        this.drugStrengthUnit = drugStrengthUnit;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public DoseUnit getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(DoseUnit doseUnit) {
        this.doseUnit = doseUnit;
    }

    public Preparation getPreparation() {
        return preparation;
    }

    public void setPreparation(Preparation preparation) {
        this.preparation = preparation;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public DurationUnit getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(DurationUnit durationUnit) {
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

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", prescription=" + prescription +
                ", drugName='" + drugName + '\'' +
                ", strength=" + strength +
                ", drugStrengthUnit=" + drugStrengthUnit +
                ", dose=" + dose +
                ", doseUnit=" + doseUnit +
                ", preparation=" + preparation +
                ", route=" + route +
                ", direction=" + direction +
                ", frequency=" + frequency +
                ", duration=" + duration +
                ", durationUnit=" + durationUnit +
                ", totalQuantity=" + totalQuantity +
                ", otherInstructions='" + otherInstructions + '\'' +
                '}';
    }
}