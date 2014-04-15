/**
 * 
 */
package com.sivalabs.tasktracker.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sivalabs.tasktracker.entities.Privilege;
import com.sivalabs.tasktracker.entities.Project;
import com.sivalabs.tasktracker.entities.Role;
import com.sivalabs.tasktracker.entities.User;
import com.sivalabs.tasktracker.entities.WorkItem;
import com.sivalabs.tasktracker.services.PrivilegeService;
import com.sivalabs.tasktracker.services.ProjectService;
import com.sivalabs.tasktracker.services.RoleService;
import com.sivalabs.tasktracker.services.UserService;

/**
 * @author Siva
 * 
 */
@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired private UserService userService;
	@Autowired private RoleService roleService;
	@Autowired private PrivilegeService privilegeService;
	
	@Autowired private ProjectService projectService;
	
	@Value("${init-db:false}")
	private String initDatabase;

	@PostConstruct
	public void init()
	{
		try {
			logger.info("############## InitDatabase :" + initDatabase + " ########################");
			if (Boolean.parseBoolean(initDatabase)) {
				initDatabase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void initDatabase()
	{

		logger.info("Initializing Database with sample data");
		
		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		
		role1 = roleService.createRole(role1);
		role2 = roleService.createRole(role2);
		
		Privilege priv1 = new Privilege(null, "CREATE_USER");
		Privilege priv2 = new Privilege(null, "CREATE_PROJECT");
		Privilege priv3 = new Privilege(null, "CREATE_TASK");
		priv1 = privilegeService.createPrivilege(priv1);
		priv2 = privilegeService.createPrivilege(priv2);
		priv3 = privilegeService.createPrivilege(priv3);
		
		roleService.addPrivilegesToRole(role2.getId(), Arrays.asList(priv1, priv2, priv3));
		roleService.addPrivilegesToRole(role1.getId(), Arrays.asList(priv3));
		
		User user1 = new User(1, "admin@gmail.com", "admin", "Administrator");
		User user2 = new User(2, "siva@gmail.com", "siva", "Siva");
		
		user1.addRoles(role1, role2);
		user2.addRoles(role1);
		
		userService.createUser(user1);
		userService.createUser(user2);
		
		Project project = new Project();
		project.setProjectName("Project 1");
		List<WorkItem> workItems = new ArrayList<>();
		WorkItem wi1 = new WorkItem();
		wi1.setCreatedBy(user2);
		wi1.setName("Setup Maven Project base template");
		wi1.setProject(project);
		wi1.setAssignedTo(user1);
		wi1.setDescription("Setup Maven Project base template with all the necessary dependencies configured");
		
		WorkItem wi2 = new WorkItem();
		wi2.setCreatedBy(user1);
		wi2.setName("Setup DB Schema");
		wi2.setProject(project);
		wi2.setAssignedTo(user2);
		wi2.setDescription("Setup DB Schema in MySQL");
		
		workItems.add(wi1);
		workItems.add(wi2);		
		
		project.setWorkItems(workItems );
		
		Project proj = projectService.createProject(project);
		System.err.println("Project created: "+proj.getId());
		project = new Project();
		project.setProjectName("Project 2");
		workItems = new ArrayList<>();
		wi1 = new WorkItem();
		wi1.setCreatedBy(user2);
		wi1.setName("Setup Maven Project base template");
		wi1.setProject(project);
		wi1.setAssignedTo(user1);
		wi1.setDescription("Setup Maven Project base template with all the necessary dependencies configured");
		
		workItems.add(wi1);
		
		project.setWorkItems(workItems );
		
		proj = projectService.createProject(project);
		System.err.println("Project created: "+proj.getId());
		
		
	}
}
