package com.jobportal.prohire.ui.controller;

import com.jobportal.prohire.bl.RecruiterManager;
import com.jobportal.prohire.io.entity.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterManager recruiterManager;

    @PostMapping("/register")
    public ResponseEntity<Recruiter> registerRecruiter(@RequestBody Recruiter recruiter) {
        Recruiter savedRecruiter = recruiterManager.registerRecruiter(recruiter);
        return ResponseEntity.ok(savedRecruiter);
    }

    @PostMapping("/login")
    public ResponseEntity<Recruiter> loginRecruiter(@RequestBody String companyEmailId) {
        Recruiter recruiter = recruiterManager.loginRecruiter(companyEmailId);
        if (recruiter != null) {
            return ResponseEntity.ok(recruiter);
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
