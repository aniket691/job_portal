package com.app.dto;

public class JobListingDTO {

	private Long jobId;
	private String jobTitle;
	private String jobDescription;
	private Long recruiterId;
	private Long skillId;

	// Constructors
	public JobListingDTO() {
	}

	public JobListingDTO(Long jobId, String jobTitle, String jobDescription, Long recruiterId, Long skillId) {
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.recruiterId = recruiterId;
		this.skillId = skillId;
	}

	// Getters and Setters
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
}
