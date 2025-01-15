package com.enviro.assessment.grad001.MmathusoKgalane.controller;

import com.enviro.assessment.grad001.MmathusoKgalane.model.WasteCategory;
import com.enviro.assessment.grad001.MmathusoKgalane.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/waste-categories") // Base URL for waste category endpoints
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service;

    @GetMapping
    public List<WasteCategory> getAllWasteCategories() {
        return service.getAllWasteCategories(); // Return all waste categories
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteCategory> getWasteCategoryById(@PathVariable Long id) {
        Optional<WasteCategory> category = service.getWasteCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public WasteCategory createWasteCategory(@RequestBody WasteCategory wasteCategory) {
        return service.saveWasteCategory(wasteCategory); // Save the waste category
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        service.deleteWasteCategory(id); // Delete the waste category by ID
        return ResponseEntity.noContent().build();
    }
}
