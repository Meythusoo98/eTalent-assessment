package com.enviro.assessment.grad001.MmathusoKgalane.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class DisposalGuideline {
    @Id
    private Long id; // Primary key for disposal guidelines

    private String wasteCategory; // The category the guideline is related to

    private String guideline; // Guideline for disposing of waste

    // Getters and setters for accessing and modifying the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(String wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }
}
