package com.app.services.impl;

import com.app.entity.Application;
import com.app.entity.ApplicationStatus;
import com.app.repository.ApplicationRepository;
import com.app.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public Application saveApplication(Application application) {
		return applicationRepository.save(application);
	}

	@Override
	public List<Application> getApplicationsByJobListingId(Long jobListingId) {
		return applicationRepository.findByJobListing_JobId(jobListingId);
	}

	@Override
	public Application updateApplicationStatus(Long applicationId, ApplicationStatus status) {
		Application application = applicationRepository.findById(applicationId)
				.orElseThrow(() -> new RuntimeException("Application not found"));
		application.setApplicationStatus(status);
		return applicationRepository.save(application);
	}

	@Override
	public void deleteApplication(Long applicationId) {
		applicationRepository.deleteById(applicationId);
	}

	@Override
	public List<Application> getAllApplications() {
		// TODO Auto-generated method stub
		return applicationRepository.findAll();
	}
}