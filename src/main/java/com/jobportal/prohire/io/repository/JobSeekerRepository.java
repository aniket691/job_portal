package com.jobportal.prohire.io.repository;

import com.jobportal.prohire.io.entity.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, UUID> {
    JobSeeker findByUserId(UUID userId);

    JobSeeker findByUsername(String username);

}

