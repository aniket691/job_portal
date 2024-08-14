package com.app.service;

import com.app.dto.ApplicationDTO;
import com.app.entity.Application;
import com.app.entity.ApplicationStatus;

import java.util.List;

public interface ApplicationService {
	Application saveApplication(Application application);

	List<Application> getApplicationsByJobListingId(Long jobListingId);

	Application updateApplicationStatus(Long applicationId, ApplicationStatus status);

	void deleteApplication(Long applicationId);

	List<Application> getAllApplications();

	List<Application> getApplicationsByRecruiterId(Long recruiterId);
}