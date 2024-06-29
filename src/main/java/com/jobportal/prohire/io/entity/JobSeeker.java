package com.jobportal.prohire.io.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.UUID;

@Entity
public class JobSeeker {

    @Id
    @GeneratedValue
    private UUID jobSeekerId;
    private String experience;
    private String profileSummary;
    private String fullName;
    private String mobileNumber;
    private UUID userId;
    private String username;
    private String password;
    @Lob
    private byte[] resume;

    // Getters and setters

    public JobSeeker() {
    }

    public JobSeeker(UUID jobSeekerId, String experience, String profileSummary, String fullName, String mobileNumber, UUID userId, String username, String password, byte[] resume) {
        this.jobSeekerId = jobSeekerId;
        this.experience = experience;
        this.profileSummary = profileSummary;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.resume = resume;
    }

    public UUID getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(UUID jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getProfileSummary() {
        return profileSummary;
    }

    public void setProfileSummary(String profileSummary) {
        this.profileSummary = profileSummary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }
}
