package com.jobportal.prohire.io.repository;

import com.jobportal.prohire.io.entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface RecruiterRepository extends JpaRepository<Recruiter, UUID> {
    Recruiter findByUsername(String username);
}
