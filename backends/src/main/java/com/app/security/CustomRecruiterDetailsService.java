package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Recruiter;
import com.app.repository.RecruiterRepository;

@Service
@Transactional
public class CustomRecruiterDetailsService implements UserDetailsService {
    @Autowired
    private RecruiterRepository recruiterRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Recruiter recruiter = recruiterRepo.findByRecruiterEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        return new CustomRecruiterDetails(recruiter);
    }
}
