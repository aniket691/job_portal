package com.app.controller;

import com.app.dto.RecruiterDTO;
import com.app.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<RecruiterDTO> createRecruiter(@RequestBody RecruiterDTO recruiterDTO) {
        RecruiterDTO createdRecruiter = recruiterService.createRecruiter(recruiterDTO);
        return ResponseEntity.ok(createdRecruiter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecruiterDTO> getRecruiterById(@PathVariable("id") long recruiterId) {
        RecruiterDTO recruiterDTO = recruiterService.getRecruiterById(recruiterId);
        return ResponseEntity.ok(recruiterDTO);
    }

    @GetMapping
    public ResponseEntity<List<RecruiterDTO>> getAllRecruiters() {
        List<RecruiterDTO> recruiters = recruiterService.getAllRecruiters();
        return ResponseEntity.ok(recruiters);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecruiterDTO> updateRecruiter(@PathVariable("id") long recruiterId,
                                                        @RequestBody RecruiterDTO recruiterDTO) {
        RecruiterDTO updatedRecruiter = recruiterService.updateRecruiter(recruiterId, recruiterDTO);
        return ResponseEntity.ok(updatedRecruiter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruiter(@PathVariable("id") long recruiterId) {
        recruiterService.deleteRecruiter(recruiterId);
        return ResponseEntity.noContent().build();
    }
}
