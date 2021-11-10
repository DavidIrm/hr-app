package com.sda.project.service;

import com.sda.project.controller.exception.ResourceNotFoundException;
import com.sda.project.model.Candidate;
import com.sda.project.model.Job;
import com.sda.project.repository.JobRepository;

import java.util.Set;

public class JobService {

    // TODO: find all

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Set<Candidate> findCandidatesForJob(Long id) {
        Job foundJob = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("job not found"));
        return foundJob.getCandidates();
    }
}
