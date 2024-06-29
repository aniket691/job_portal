package com.jobportal.prohire.service.impl;

import com.jobportal.prohire.io.entity.JobSeeker;
import com.jobportal.prohire.io.repository.JobSeekerRepository;
import com.jobportal.prohire.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Override
    public JobSeeker save(JobSeeker jobSeeker) {
        return jobSeekerRepository.save(jobSeeker);
    }

    @Override
    public JobSeeker findByUserId(UUID userId) {
        return null;
    }
    @Override
    public JobSeeker findByUserName(String username) {
        return jobSeekerRepository.findByUsername(username);
    }

}
