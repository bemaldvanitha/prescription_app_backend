package com.bemal.prescription_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "drug_strength_unit")
public class DrugStrengthUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit")
    private String unit;

    public DrugStrengthUnit() {
    }

    public DrugStrengthUnit(Long id, String unit) {
        this.id = id;
        this.unit = unit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "DrugStrengthUnit{" +
                "id=" + id +
                ", unit='" + unit + '\'' +
                '}';
    }
}
