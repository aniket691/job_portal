package com.app.repository;

import com.app.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
	List<Application> findByJobListing_JobId(Long jobId);
	// Method to find applications by recruiter ID
    List<Application> findByJobListing_Recruiter_RecruiterId(Long recruiterId);
}