package com.app.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entity.JobSeeker;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("serial")
public class CustomJobSeekerDetails implements UserDetails {
    private JobSeeker jobSeeker;

    public CustomJobSeekerDetails(JobSeeker jobSeeker) {
        super();
        this.jobSeeker = jobSeeker;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming JobSeeker has a role
        return List.of(new SimpleGrantedAuthority(jobSeeker.getUserType().name()));
    }

    @Override
    public String getPassword() {
        return jobSeeker.getJobSeekerPassword();
    }

    @Override
    public String getUsername() {
        return jobSeeker.getJobSeekerEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }
}
