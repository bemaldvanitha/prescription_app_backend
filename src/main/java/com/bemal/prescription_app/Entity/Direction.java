package com.bemal.prescription_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direction")
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "direction")
    private String direction;

    public Direction() {
    }

    public Direction(Long id, String direction) {
        this.id = id;
        this.direction = direction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "id=" + id +
                ", direction='" + direction + '\'' +
                '}';
    }
}
