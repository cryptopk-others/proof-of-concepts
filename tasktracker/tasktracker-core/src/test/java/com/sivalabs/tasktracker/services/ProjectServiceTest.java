/**
 * 
 */
package com.sivalabs.tasktracker.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.tasktracker.config.AppConfig;
import com.sivalabs.tasktracker.entities.Project;
import com.sivalabs.tasktracker.entities.WorkItem;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class ProjectServiceTest 
{
	@Autowired private ProjectService projectService;
	
	@Test
	public void testFindAllProjects() {
		List<Project> projects = projectService.findAllProjects();
		Assert.assertNotNull(projects);
	}

	@Test
	public void testFindProjectById() {
		Project project = projectService.findProjectById(1);
		Assert.assertNotNull(project);
	}

	@Test
	public void testCreateProject() {
		Project project = new Project();
		projectService.createProject(project );
	}

	@Test
	public void testUpdateProject() {
		Project project = new Project();
		projectService.updateProject(project );
	}

	@Test
	public void testDeleteProject() {
		projectService.deleteProject(2);
	}

	@Test
	public void testGetProjectWorkItems() {
		List<WorkItem> projectWorkItems = projectService.getProjectWorkItems(1);
		Assert.assertNotNull(projectWorkItems);
	}

	@Test
	public void testCreateWorkItem() {
		WorkItem workItem = new WorkItem();
		projectService.createWorkItem(1, workItem );
	}

	@Test
	public void testUpdateWorkItem() {
		WorkItem workItem = new WorkItem();
		projectService.updateWorkItem(workItem );
	}

	@Test
	public void testDeleteWorkItem() {
		projectService.deleteWorkItem(3);
	}
}
