package com.jobportal.prohire.service.impl;

import com.jobportal.prohire.io.entity.JobListing;
import com.jobportal.prohire.io.repository.JobListingRepository;
import com.jobportal.prohire.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class JobListingServiceImpl implements JobListingService {

    @Autowired
    private JobListingRepository jobListingRepository;

    @Override
    public JobListing save(JobListing jobListing) {
        return jobListingRepository.save(jobListing);
    }

    @Override
    public JobListing findById(UUID id) {
        return jobListingRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobListing> findAll() {
        return jobListingRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        jobListingRepository.deleteById(id);
    }
}

