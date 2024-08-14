package com.app.entity;

import java.util.Arrays;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "job_seekers")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobseeker_id")
	private Long jobSeekerId;

	@NotBlank(message = "Job seeker full name cannot be blank")
	@Size(max = 100, message = "Full name cannot exceed 100 characters")
	@Column(name = "jobseeker_fullname", nullable = false)
	private String jobSeekerFullName;

	@NotBlank(message = "Mobile number cannot be blank")
	@Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Mobile number should be valid")
	@Column(name = "jobseeker_mobilenumber", nullable = false, unique = true)
	private String jobSeekerMobileNumber;

	@Size(max = 500, message = "Profile summary cannot exceed 500 characters")
	@Column(name = "jobseeker_profilesummary")
	private String jobSeekerProfileSummary;

	@Min(value = 0, message = "Experience cannot be negative")
	@Max(value = 50, message = "Experience seems unrealistic")
	@Column(name = "jobseeker_experience")
	private Long jobSeekerExperience;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "jobseeker_resume")
	private byte[] jobSeekerResume;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email should be valid")
	@Column(name = "jobseeker_email", nullable = false, unique = true)
	private String jobSeekerEmail;

	@NotBlank(message = "Password cannot be blank")
	@Size(min = 8, message = "Password should have at least 8 characters")
	@Column(name = "jobseeker_password", nullable = false)
	private String jobSeekerPassword;

	@Size(max = 100, message = "Location cannot exceed 100 characters")
	@Column(name = "jobseeker_location")
	private String location;

	@Column(name = "verification_token", unique = true)
	private String verificationToken;

	@Column(name = "email_verified", nullable = false)
	private boolean emailVerified;

	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "subscription_id", unique = true)
	private Subscription subscription;

	// Getters and Setters
	public Long getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(Long jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}

	public String getJobSeekerFullName() {
		return jobSeekerFullName;
	}

	public void setJobSeekerFullName(String jobSeekerFullName) {
		this.jobSeekerFullName = jobSeekerFullName;
	}

	public String getJobSeekerMobileNumber() {
		return jobSeekerMobileNumber;
	}

	public void setJobSeekerMobileNumber(String jobSeekerMobileNumber) {
		this.jobSeekerMobileNumber = jobSeekerMobileNumber;
	}

	public String getJobSeekerProfileSummary() {
		return jobSeekerProfileSummary;
	}

	public void setJobSeekerProfileSummary(String jobSeekerProfileSummary) {
		this.jobSeekerProfileSummary = jobSeekerProfileSummary;
	}

	public Long getJobSeekerExperience() {
		return jobSeekerExperience;
	}

	public void setJobSeekerExperience(Long jobSeekerExperience) {
		this.jobSeekerExperience = jobSeekerExperience;
	}

	public byte[] getJobSeekerResume() {
		return jobSeekerResume;
	}

	public void setJobSeekerResume(byte[] jobSeekerResume) {
		this.jobSeekerResume = jobSeekerResume;
	}

	public String getJobSeekerEmail() {
		return jobSeekerEmail;
	}

	public void setJobSeekerEmail(String jobSeekerEmail) {
		this.jobSeekerEmail = jobSeekerEmail;
	}

	public String getJobSeekerPassword() {
		return jobSeekerPassword;
	}

	public void setJobSeekerPassword(String jobSeekerPassword) {
		this.jobSeekerPassword = jobSeekerPassword;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	@Override
	public String toString() {
		return "JobSeeker{" + "jobSeekerId=" + jobSeekerId + ", jobSeekerFullName='" + jobSeekerFullName + '\''
				+ ", jobSeekerMobileNumber='" + jobSeekerMobileNumber + '\'' + ", jobSeekerProfileSummary='"
				+ jobSeekerProfileSummary + '\'' + ", jobSeekerExperience=" + jobSeekerExperience + ", jobSeekerResume="
				+ Arrays.toString(jobSeekerResume) + ", jobSeekerEmail='" + jobSeekerEmail + '\''
				+ ", jobSeekerPassword='" + jobSeekerPassword + '\'' + ", location='" + location + '\''
				+ ", verificationToken='" + verificationToken + '\'' + ", emailVerified=" + emailVerified + ", skill="
				+ skill + ", subscription=" + subscription + '}';
	}
}
