package com.jobportal.prohire.ui.models.request;

import java.util.Arrays;

public class JobSeekerRegisterRequest {
    private String fullName;
    private String experience;
    private String profileSummary;
    private String mobileNumber;
    private String username;
    private String password;

    // Getters and setters
    public JobSeekerRegisterRequest(String fullName, String experience, String profileSummary, String mobileNumber, String username, String password) {
        this.fullName = fullName;
        this.experience = experience;
        this.profileSummary = profileSummary;
        this.mobileNumber = mobileNumber;
        this.username = username;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
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

    @Override
    public String toString() {
        return "JobSeekerRegisterRequest{" +
                "fullName='" + fullName + '\'' +
                ", experience='" + experience + '\'' +
                ", profileSummary='" + profileSummary + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'';
    }

}
