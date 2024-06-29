package com.jobportal.prohire.io.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Recruiter {

    @Id
    @GeneratedValue
    private UUID recruiterId;
    private String fullName;
    private String companyName;
    private String contactNumber;
    private String position;
    private String companyEmailId;
    private String username;
    private String password;

    public Recruiter(UUID recruiterId, String fullName, String companyName, String contactNumber, String position, String companyEmailId, String username, String password) {
        this.recruiterId = recruiterId;
        this.fullName = fullName;
        this.companyName = companyName;
        this.contactNumber = contactNumber;
        this.position = position;
        this.companyEmailId = companyEmailId;
        this.username = username;
        this.password = password;
    }
    // Getters and setters

    public UUID getRecruiterId() {
        return recruiterId;
    }

    public void setRecruiterId(UUID recruiterId) {
        this.recruiterId = recruiterId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanyEmailId() {
        return companyEmailId;
    }

    public void setCompanyEmailId(String companyEmailId) {
        this.companyEmailId = companyEmailId;
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
}