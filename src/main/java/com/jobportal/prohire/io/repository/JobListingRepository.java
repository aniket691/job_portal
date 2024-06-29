package com.jobportal.prohire.io.repository;

import com.jobportal.prohire.io.entity.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JobListingRepository extends JpaRepository<JobListing, UUID> {
}
