package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.app.entity.Application;
import com.app.entity.ApplicationStatus;
import com.app.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/createApplication")
	public ResponseEntity<Application> createApplication(@RequestBody Application application) {
		Application savedApplication = applicationService.saveApplication(application);
		return ResponseEntity.ok(savedApplication);
	}

	@GetMapping("/job/{jobListingId}")
	public ResponseEntity<List<Application>> getApplicationsByJobListingId(@PathVariable Long jobListingId) {
		List<Application> applications = applicationService.getApplicationsByJobListingId(jobListingId);
		return ResponseEntity.ok(applications);
	}

	@PutMapping("/{applicationId}/status")
	public ResponseEntity<Application> updateApplicationStatus(@PathVariable Long applicationId,
			@RequestBody ApplicationStatus status) {
		Application updatedApplication = applicationService.updateApplicationStatus(applicationId, status);
		return ResponseEntity.ok(updatedApplication);
	}

	@DeleteMapping("/{applicationId}")
	public ResponseEntity<Void> deleteApplication(@PathVariable Long applicationId) {
		applicationService.deleteApplication(applicationId);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getAllApplications")
	public List<Application> getAllApplications() {
		return applicationService.getAllApplications();
	}

	@GetMapping("/recruiter/{recruiterId}")
	public ResponseEntity<List<Application>> getApplicationsByRecruiterId(@PathVariable Long recruiterId) {
		List<Application> applications = applicationService.getApplicationsByRecruiterId(recruiterId);
		return ResponseEntity.ok(applications);
	}
}