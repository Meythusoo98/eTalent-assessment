package com.enviro.assessment.grad001.MmathusoKgalane.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class RecyclingTip {
    @Id
    private Long id; // Primary key for recycling tips

    private String tip; // Recycling tip text

    // Getters and setters for accessing and modifying the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
