/**
 * 
 */
package com.sivalabs.tasktracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.tasktracker.entities.Project;
import com.sivalabs.tasktracker.entities.WorkItem;
import com.sivalabs.tasktracker.repositories.ProjectRepository;
import com.sivalabs.tasktracker.repositories.UserRepository;
import com.sivalabs.tasktracker.repositories.WorkItemRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class ProjectService {

	@Autowired private ProjectRepository projectRepository;
	@Autowired private UserRepository userRepository;
	@Autowired private WorkItemRepository workItemRepository;
	
	public List<Project> findAllProjects() {
		return projectRepository.findAll();
	}

	public Project findProjectById(int projectId) {
		return projectRepository.findOne(projectId);
	}
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
	
	public void deleteProject(int projectId) {
		projectRepository.delete(projectId);
	}
	
	public List<WorkItem> getProjectWorkItems(int projectId) {
		Project project = findProjectById(projectId);
		return project.getWorkItems();		 
	}

	public void createWorkItem(int projectId, WorkItem workItem) {
		Project project = findProjectById(projectId);
		project.getWorkItems().add(workItem);
	}
	
	public WorkItem updateWorkItem(WorkItem workItem) {
		return workItemRepository.save(workItem);
	}
	
	public void deleteWorkItem(int workItemId) {
		workItemRepository.delete(workItemId);
	}	
	
	
}
