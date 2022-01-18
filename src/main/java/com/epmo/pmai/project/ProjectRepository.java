package com.epmo.pmai.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface ProjectRepository extends JpaRepository<Project, Long>{
    Optional<Project> findById(Long id);
}
