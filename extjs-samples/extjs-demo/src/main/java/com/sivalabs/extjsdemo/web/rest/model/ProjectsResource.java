/**
 * 
 */
package com.sivalabs.extjsdemo.web.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.sivalabs.extjsdemo.entities.Project;

/**
 * @author Siva
 *
 */
@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)

public class ProjectsResource {

	@XmlElementWrapper(name="projects")
	@XmlElement(name="project")
	private List<Project> projects = new ArrayList<>();

	public ProjectsResource()
	{
	}

	public ProjectsResource(List<Project> projects)
	{
		this.projects = projects;
	}

	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


}
