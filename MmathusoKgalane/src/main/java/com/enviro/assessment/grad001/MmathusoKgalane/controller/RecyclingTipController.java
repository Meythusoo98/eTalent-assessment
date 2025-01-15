package com.enviro.assessment.grad001.MmathusoKgalane.controller;

import com.enviro.assessment.grad001.MmathusoKgalane.model.RecyclingTip;
import com.enviro.assessment.grad001.MmathusoKgalane.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    @Autowired
    private RecyclingTipService service;

    @GetMapping
    public List<RecyclingTip> getAllRecyclingTips() {
        return service.getAllRecyclingTips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        Optional<RecyclingTip> tip = service.getRecyclingTipById(id);
        return tip.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RecyclingTip createRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        return service.saveRecyclingTip(recyclingTip);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        service.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}
