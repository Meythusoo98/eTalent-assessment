package com.enviro.assessment.grad001.MmathusoKgalane.service;

import com.enviro.assessment.grad001.MmathusoKgalane.model.WasteCategory;
import com.enviro.assessment.grad001.MmathusoKgalane.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository; // Inject the repository

    // Get all waste categories
    public List<WasteCategory> getAllWasteCategories() {
        return repository.findAll(); // Fetch all waste categories from the database
    }

    // Get a waste category by its ID
    public Optional<WasteCategory> getWasteCategoryById(Long id) {
        return repository.findById(id); // Fetch the waste category by ID
    }

    // Save a new or updated waste category
    public WasteCategory saveWasteCategory(WasteCategory wasteCategory) {
        return repository.save(wasteCategory); // Save the waste category to the database
    }

    // Delete a waste category by its ID
    public void deleteWasteCategory(Long id) {
        repository.deleteById(id); // Delete the waste category by ID
    }
}