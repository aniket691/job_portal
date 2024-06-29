package com.jobportal.prohire.ui.controller;

import com.jobportal.prohire.bl.JobSeekerManager;
import com.jobportal.prohire.io.entity.JobSeeker;
import com.jobportal.prohire.ui.models.request.JobSeekerRegisterRequest;
import com.jobportal.prohire.ui.models.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {

    @Autowired
    private JobSeekerManager jobSeekerManager;

    @PostMapping("/register")
    public ResponseEntity<JobSeeker> registerJobSeeker(@RequestBody JobSeekerRegisterRequest request) {
        JobSeeker savedJobSeeker = jobSeekerManager.registerJobSeeker(request);
        return ResponseEntity.ok(savedJobSeeker);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginJobSeeker(@RequestBody LoginRequest request) {
        JobSeeker jobSeeker = jobSeekerManager.loginJobSeeker(request.getUsername(), request.getPassword());
        if (jobSeeker != null) {
            return ResponseEntity.ok(jobSeeker);
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}