/**
 * 
 */
package com.sivalabs.tasktracker.model;

import java.io.Serializable;

/**
 * @author Siva
 *
 */
public class ConfigParameter implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String value;
	private String description;
	
	public ConfigParameter() {
	}
	public ConfigParameter(int id) {
		this.id = id;
	}
	public ConfigParameter(int id, String name, String value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}
	public ConfigParameter(int id, String name, String value, String description) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
