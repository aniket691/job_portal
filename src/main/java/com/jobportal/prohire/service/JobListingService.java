package com.jobportal.prohire.service;

import com.jobportal.prohire.io.entity.JobListing;

import java.util.List;
import java.util.UUID;

public interface JobListingService {
    JobListing save(JobListing jobListing);

    JobListing findById(UUID id);

    List<JobListing> findAll();

    void deleteById(UUID id);
}

