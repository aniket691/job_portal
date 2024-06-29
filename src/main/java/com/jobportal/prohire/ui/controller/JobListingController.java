package com.jobportal.prohire.ui.controller;

import com.jobportal.prohire.bl.JobListingManager;
import com.jobportal.prohire.io.entity.JobListing;
import com.jobportal.prohire.ui.models.request.JobListingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/joblistings")
public class JobListingController {

    @Autowired
    private JobListingManager jobListingManager;

    @PostMapping
    public ResponseEntity<JobListing> createJobListing(@RequestBody JobListingRequest jobListingRequest) {
        JobListing jobListing = new JobListing();
        jobListing.setJobDescription(jobListingRequest.getJobDescription());
        jobListing.setJobTitle(jobListingRequest.getJobTitle());
        JobListing savedJobListing = jobListingManager.createJobListing(jobListingRequest.getUsername(), jobListing);
        return ResponseEntity.ok(savedJobListing);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobListing> getJobListingById(@PathVariable UUID id) {
        JobListing jobListing = jobListingManager.getJobListingById(id);
        return ResponseEntity.ok(jobListing);
    }

    @GetMapping
    public ResponseEntity<List<JobListing>> getAllJobListings() {
        List<JobListing> jobListings = jobListingManager.getAllJobListings();
        return ResponseEntity.ok(jobListings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobListing> updateJobListing(@PathVariable UUID id, @RequestBody JobListingRequest jobListingRequest) {
        JobListing jobListing = new JobListing();
        jobListing.setJobDescription(jobListingRequest.getJobDescription());
        jobListing.setJobTitle(jobListingRequest.getJobTitle());
        JobListing updatedJobListing = jobListingManager.updateJobListing(id, jobListing);
        return ResponseEntity.ok(updatedJobListing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobListing(@PathVariable UUID id) {
        jobListingManager.deleteJobListing(id);
        return ResponseEntity.noContent().build();
    }
}
