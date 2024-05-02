package com.bemal.prescription_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "frequency")
public class Frequency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "frequency")
    private String frequency;

    public Frequency() {
    }

    public Frequency(Long id, String frequency) {
        this.id = id;
        this.frequency = frequency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Frequency{" +
                "id=" + id +
                ", frequency='" + frequency + '\'' +
                '}';
    }
}
