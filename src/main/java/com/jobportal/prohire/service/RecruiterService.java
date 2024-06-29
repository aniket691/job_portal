package com.jobportal.prohire.service;

import com.jobportal.prohire.io.entity.JobSeeker;
import com.jobportal.prohire.io.entity.Recruiter;

public interface RecruiterService {
    Recruiter save(Recruiter recruiter);
    Recruiter findByUserName(String username);
}
