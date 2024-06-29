package com.jobportal.prohire.bl;

import com.jobportal.prohire.io.entity.JobListing;
import com.jobportal.prohire.io.entity.Recruiter;
import com.jobportal.prohire.service.JobListingService;
import com.jobportal.prohire.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class JobListingManager {

    @Autowired
    private JobListingService jobListingService;

    @Autowired
    private RecruiterService recruiterService;

    public JobListing createJobListing(String username, JobListing jobListing) {
        Recruiter recruiter = recruiterService.findByUserName(username);
        if (recruiter != null) {
            jobListing.setRecruiter(recruiter);
            return jobListingService.save(jobListing);
        } else {
            throw new IllegalArgumentException("Recruiter not found");
        }
    }

    public JobListing getJobListingById(UUID id) {
        return jobListingService.findById(id);
    }

    public List<JobListing> getAllJobListings() {
        return jobListingService.findAll();
    }

    public JobListing updateJobListing(UUID id, JobListing jobListing) {
        JobListing existingJobListing = jobListingService.findById(id);
        if (existingJobListing != null) {
            existingJobListing.setJobDescription(jobListing.getJobDescription());
            existingJobListing.setJobTitle(jobListing.getJobTitle());
            // Set recruiter if needed
            return jobListingService.save(existingJobListing);
        } else {
            throw new IllegalArgumentException("Job listing not found");
        }
    }

    public void deleteJobListing(UUID id) {
        jobListingService.deleteById(id);
    }
}
