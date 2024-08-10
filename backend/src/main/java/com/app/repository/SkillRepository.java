package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill,Long> {

}
