package com.jobportal.prohire.bl;

import com.jobportal.prohire.io.entity.JobSeeker;
import com.jobportal.prohire.service.JobSeekerService;
import com.jobportal.prohire.ui.models.request.JobSeekerRegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JobSeekerManager {

    @Autowired
    private JobSeekerService jobSeekerService;

    public JobSeeker registerJobSeeker(JobSeekerRegisterRequest request) {
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setFullName(request.getFullName());
        jobSeeker.setExperience(request.getExperience());
        jobSeeker.setProfileSummary(request.getProfileSummary());
        jobSeeker.setMobileNumber(request.getMobileNumber());
        jobSeeker.setUsername(request.getUsername());
        jobSeeker.setPassword(request.getPassword()); // In real scenarios, password should be hashed
        jobSeeker.setUserId(UUID.randomUUID());
//        jobSeeker.setResume(request.getResume());
        return jobSeekerService.save(jobSeeker);
    }

    public JobSeeker loginJobSeeker(String username, String password) {
        JobSeeker jobSeeker = jobSeekerService.findByUserName(username);
        if (jobSeeker != null && jobSeeker.getPassword().equals(password)) {
            return jobSeeker;
        }
        return null;
    }
}