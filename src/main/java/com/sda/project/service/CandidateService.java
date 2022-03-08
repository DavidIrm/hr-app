package com.sda.project.service;

import com.sda.project.controller.exception.ResourceNotFoundException;
import com.sda.project.model.Candidate;
import com.sda.project.repository.CandidateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    private static final Logger log = LoggerFactory.getLogger(CandidateService.class);

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository companyRepository) {
        this.candidateRepository = companyRepository;
    }

    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);

    }

    public List<Candidate> findAll() {
        return candidateRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    public Candidate findById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("candidate not found"));
    }
}
