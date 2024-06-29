package com.jobportal.prohire.io.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class JobListing {

    @Id
    @GeneratedValue
    private UUID jobId;
    private String jobDescription;
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "recruiter_id", referencedColumnName = "recruiterId")
    private Recruiter recruiter;

    public JobListing() {

    }

    public JobListing(UUID jobId, String jobDescription, String jobTitle, Recruiter recruiter) {
        this.jobId = jobId;
        this.jobDescription = jobDescription;
        this.jobTitle = jobTitle;
        this.recruiter = recruiter;
    }

    // Getters and setters

    public UUID getJobId() {
        return jobId;
    }

    public void setJobId(UUID jobId) {
        this.jobId = jobId;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }
}