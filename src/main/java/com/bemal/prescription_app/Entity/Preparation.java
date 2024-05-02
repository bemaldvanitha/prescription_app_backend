package com.bemal.prescription_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "preparation")
public class Preparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preparation")
    private String preparation;

    public Preparation() {
    }

    public Preparation(Long id, String preparation) {
        this.id = id;
        this.preparation = preparation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    @Override
    public String toString() {
        return "Preparation{" +
                "id=" + id +
                ", preparation='" + preparation + '\'' +
                '}';
    }
}
