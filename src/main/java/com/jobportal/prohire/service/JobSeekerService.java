package com.jobportal.prohire.service;

import com.jobportal.prohire.io.entity.JobSeeker;

import java.util.UUID;

public interface JobSeekerService {
    JobSeeker save(JobSeeker jobSeeker);
    JobSeeker findByUserId(UUID userId);

    JobSeeker findByUserName(String username);

}
