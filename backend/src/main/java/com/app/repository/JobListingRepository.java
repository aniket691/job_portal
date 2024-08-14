package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.JobListing;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {
    List<JobListing> findByRecruiterRecruiterId(Long recruiterId); // Custom query method
}