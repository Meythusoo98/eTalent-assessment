package com.enviro.assessment.grad001.MmathusoKgalane.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WasteCategory {

    @Id
    private Long id; // Primary key for identifying waste categories

    private String name; // Name of the waste category

    private String description; // Description of the category

    // Getters and setters for accessing and modifying the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
