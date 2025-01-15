package com.enviro.assessment.grad001.MmathusoKgalane.repository;

import com.enviro.assessment.grad001.MmathusoKgalane.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecyclingTipRepository extends JpaRepository<RecyclingTip, Long> {
    // Basic CRUD operations are inherited from JpaRepository
}