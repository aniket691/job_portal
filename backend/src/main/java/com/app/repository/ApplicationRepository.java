package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
	List<Application> findByJobListing_JobId(Long jobId);
}