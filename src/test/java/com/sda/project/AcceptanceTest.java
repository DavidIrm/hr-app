package com.sda.project;

import com.sda.project.model.Candidate;
import com.sda.project.model.Company;
import com.sda.project.model.Job;
import com.sda.project.model.User;
import com.sda.project.service.CandidateService;
import com.sda.project.service.CompanyService;
import com.sda.project.service.JobService;
import com.sda.project.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AcceptanceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private CandidateService candidateService;

    @Test
    void acceptanceTest() {
        User companyUser = userService.findByEmail("admin@gmail.com");
        User customerUser = userService.findByEmail("user@gmail.com");

        // company registers
        Company company = new Company();
        company.setName("company 1");
        company.setUser(companyUser);
        companyService.save(company);

        // company creates jobs
        Job job = new Job();
        job.setJobName("java dev");
        jobService.save(job);

        // candidate registers
        Candidate candidate = new Candidate();
        candidate.setUser(customerUser);
        candidate.addJob(job);
        candidateService.save(candidate);

        Candidate savedCandidate = candidateService.findById(candidate.getId());

        // see candidates for a job

        // see candidate job list

        assertThat(savedCandidate).isEqualTo(candidate);
    }
}
