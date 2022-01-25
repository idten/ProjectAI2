package com.epmo.pmai.config;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long> {

}
