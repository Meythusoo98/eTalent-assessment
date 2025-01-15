package com.enviro.assessment.grad001.MmathusoKgalane.service;

import com.enviro.assessment.grad001.MmathusoKgalane.model.DisposalGuideline;
import com.enviro.assessment.grad001.MmathusoKgalane.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisposalGuidelineService {

    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuideline> getAllDisposalGuidelines() {
        return repository.findAll();
    }

    public Optional<DisposalGuideline> getDisposalGuidelineById(Long id) {
        return repository.findById(id);
    }

    public DisposalGuideline saveDisposalGuideline(DisposalGuideline guideline) {
        return repository.save(guideline);
    }

    public void deleteDisposalGuideline(Long id) {
        repository.deleteById(id);
    }
}