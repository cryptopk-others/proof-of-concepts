/**
 * 
 */
package com.sivalabs.tasktracker.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sivalabs.tasktracker.model.ConfigParameter;

/**
 * @author Siva
 *
 */
@ManagedBean
@ViewScoped
public class EmailSettingsController implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<ConfigParameter> configParameters;
	
	public EmailSettingsController() {
		configParameters = new ArrayList<>();
		configParameters.add(new ConfigParameter(1, "smtp.host", "google.com"));
		configParameters.add(new ConfigParameter(2, "smtp.port", "25"));
		configParameters.add(new ConfigParameter(3, "smtp.user", "siva@gmail.com"));
		
	}
	public List<ConfigParameter> getConfigParameters() {
		return configParameters;
	}
	public void setConfigParameters(List<ConfigParameter> configParameters) {
		this.configParameters = configParameters;
	}
}
