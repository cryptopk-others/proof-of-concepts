/**
 * 
 */
package com.sivalabs.tasktracker.web.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import com.sivalabs.tasktracker.entities.Privilege;
import com.sivalabs.tasktracker.entities.Role;
import com.sivalabs.tasktracker.web.converters.PrivilegeConverter;

/**
 * @author Siva
 *
 */
@ManagedBean
@ViewScoped
public class RolePrivilegesController implements Serializable
{
	private static final long serialVersionUID = 1L;
	private List<Role> roles;
	private Role selectedRole;
	private DualListModel<Privilege> privilegesModel;
	
	public RolePrivilegesController() 
	{
		roles = new ArrayList<>();
		roles.add(new Role(1, "ROLE_USER"));
		roles.add(new Role(2, "ROLE_ADMIN"));
		
		List<Privilege> sourcePrivileges = PrivilegeConverter.getPrivileges();
		List<Privilege> targetPrivileges = new ArrayList<>();
		
		privilegesModel = new DualListModel<>(sourcePrivileges, targetPrivileges);
	}

	public void onTransfer(TransferEvent event)
	{
		StringBuilder builder = new StringBuilder();
		for (Object item : event.getItems()) {
			builder.append(((Privilege)item).getName()).append("<br />");
			//builder.append(item).append("<br />");
		}
		String msg = null;
		if (event.isAdd()) {
			msg = "Assigned Privileges:<br/>" + builder.toString();
		} else {
			msg = "Revoked Privileges:<br/>" + builder.toString();
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(Role selectedRole) {
		this.selectedRole = selectedRole;
	}

	public DualListModel<Privilege> getPrivilegesModel() {
		return privilegesModel;
	}

	public void setPrivilegesModel(DualListModel<Privilege> privilegesModel) {
		this.privilegesModel = privilegesModel;
	}
	
	
}
