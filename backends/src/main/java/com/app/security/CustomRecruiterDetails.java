package com.app.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entity.Recruiter;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("serial")
public class CustomRecruiterDetails implements UserDetails {
    private Recruiter recruiter;

    public CustomRecruiterDetails(Recruiter recruiter) {
        super();
        this.recruiter = recruiter;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming Recruiter has a role
        return List.of(new SimpleGrantedAuthority(recruiter.getUserType().name()));
    }

    @Override
    public String getPassword() {
        return recruiter.getRecruiterPassword();
    }

    @Override
    public String getUsername() {
        return recruiter.getRecruiterEmail();
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

    public Recruiter getRecruiter() {
        return recruiter;
    }
}
