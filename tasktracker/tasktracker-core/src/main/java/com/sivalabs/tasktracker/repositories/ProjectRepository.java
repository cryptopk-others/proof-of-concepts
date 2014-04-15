package com.sivalabs.tasktracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.tasktracker.entities.Project;

/**
 * @author Siva
 * 
 */
public interface ProjectRepository extends JpaRepository<Project, Integer>
{

}
