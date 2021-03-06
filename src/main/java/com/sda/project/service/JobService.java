package com.sda.project.service;

import com.sda.project.controller.exception.ResourceNotFoundException;
import com.sda.project.model.Candidate;
import com.sda.project.model.Job;
import com.sda.project.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Set<Candidate> findCandidatesForJob(Long id) {
        Job foundJob = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("job not found"));
        return foundJob.getCandidates();
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

}
