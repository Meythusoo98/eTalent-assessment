package com.enviro.assessment.grad001.MmathusoKgalane.controller;

import com.enviro.assessment.grad001.MmathusoKgalane.model.DisposalGuideline;
import com.enviro.assessment.grad001.MmathusoKgalane.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    @Autowired
    private DisposalGuidelineService service;

    @GetMapping
    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return service.getAllDisposalGuidelines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        Optional<DisposalGuideline> guideline = service.getDisposalGuidelineById(id);
        return guideline.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DisposalGuideline createDisposalGuideline(@RequestBody DisposalGuideline guideline) {
        return service.saveDisposalGuideline(guideline);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        service.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
