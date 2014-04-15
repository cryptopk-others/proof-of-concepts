package com.sivalabs.tasktracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.tasktracker.entities.WorkItem;

/**
 * @author Siva
 * 
 */
public interface WorkItemRepository extends JpaRepository<WorkItem, Integer>
{

}
