package com.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.JobSeeker;
import com.app.repository.JobSeekerRepository;

@Service
@Transactional
public class CustomJobSeekerDetailsService implements UserDetailsService {
    @Autowired
    private JobSeekerRepository jobSeekerRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        JobSeeker jobSeeker = jobSeekerRepo.findByJobSeekerEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        return new CustomJobSeekerDetails(jobSeeker);
    }
}
