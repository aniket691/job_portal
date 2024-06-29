package com.jobportal.prohire.bl;

import com.jobportal.prohire.io.entity.Recruiter;
import com.jobportal.prohire.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecruiterManager {

    @Autowired
    private RecruiterService recruiterService;

    public Recruiter registerRecruiter(Recruiter recruiter) {
        // Add business logic here
        return recruiterService.save(recruiter);
    }

    public Recruiter loginRecruiter(String username) {
        // Add business logic here
        return recruiterService.findByUserName(username);
    }
}
