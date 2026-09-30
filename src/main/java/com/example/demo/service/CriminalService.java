package com.example.demo.service;

import com.example.demo.model.Criminal;
import com.example.demo.repository.CriminalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalService {

    private final CriminalRepository criminalRepository;

    public CriminalService(CriminalRepository criminalRepository) {
        this.criminalRepository = criminalRepository;
    }

    public List<Criminal> getAllCriminals() {
        return criminalRepository.findAll();
    }

    public Criminal saveCriminal (Criminal criminal) {
        return criminalRepository.save(criminal);
    }
}