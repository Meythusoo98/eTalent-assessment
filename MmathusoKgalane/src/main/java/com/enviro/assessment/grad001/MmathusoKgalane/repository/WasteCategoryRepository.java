package com.enviro.assessment.grad001.MmathusoKgalane.repository;

import com.enviro.assessment.grad001.MmathusoKgalane.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    // Basic CRUD operations are inherited from JpaRepository
}
