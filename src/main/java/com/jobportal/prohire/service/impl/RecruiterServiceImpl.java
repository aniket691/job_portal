package com.jobportal.prohire.service.impl;

import com.jobportal.prohire.io.entity.Recruiter;
import com.jobportal.prohire.io.repository.RecruiterRepository;
import com.jobportal.prohire.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterServiceImpl implements RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Override
    public Recruiter save(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    @Override
    public Recruiter findByUserName(String username) {
        return recruiterRepository.findByUsername(username);
    }

}
