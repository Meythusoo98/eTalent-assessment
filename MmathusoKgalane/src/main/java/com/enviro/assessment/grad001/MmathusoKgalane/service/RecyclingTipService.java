package com.enviro.assessment.grad001.MmathusoKgalane.service;

import com.enviro.assessment.grad001.MmathusoKgalane.model.RecyclingTip;
import com.enviro.assessment.grad001.MmathusoKgalane.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public List<RecyclingTip> getAllRecyclingTips() {
        return repository.findAll();
    }

    public Optional<RecyclingTip> getRecyclingTipById(Long id) {
        return repository.findById(id);
    }

    public RecyclingTip saveRecyclingTip(RecyclingTip recyclingTip) {
        return repository.save(recyclingTip);
    }

    public void deleteRecyclingTip(Long id) {
        repository.deleteById(id);
    }
}
