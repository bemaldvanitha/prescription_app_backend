package com.bemal.prescription_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "height_unit")
public class HeightUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit")
    private String unit;

    public HeightUnit() {
    }

    public HeightUnit(Long id, String unit) {
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
        return "HeightUnit{" +
                "id=" + id +
                ", unit='" + unit + '\'' +
                '}';
    }
}
