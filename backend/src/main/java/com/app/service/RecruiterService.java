package com.app.service;

import com.app.dto.RecruiterDTO;
import com.app.entity.Recruiter;

import java.util.List;

public interface RecruiterService {
    RecruiterDTO createRecruiter(RecruiterDTO recruiterDTO);
    RecruiterDTO getRecruiterById(long recruiterId);
    List<RecruiterDTO> getAllRecruiters();
    RecruiterDTO updateRecruiter(long recruiterId, RecruiterDTO recruiterDTO);
    void deleteRecruiter(long recruiterId);
}
