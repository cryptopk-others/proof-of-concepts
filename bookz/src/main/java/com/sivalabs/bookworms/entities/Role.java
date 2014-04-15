/**
 * 
 */
package com.sivalabs.bookworms.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "ROLES")
public class Role extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Column(name="role_name",nullable=false)
	private String roleName;
	
	public Role() {
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	public Role(Integer id, String roleName) {
		super.setId(id);
		this.roleName = roleName;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
