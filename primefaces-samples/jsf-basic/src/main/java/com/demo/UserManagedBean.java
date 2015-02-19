/**
 * 
 */
package com.demo;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author skatam
 *
 */
@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private User loginUser;
	private User registerUser;
	private String name;
	
	
	public User getLoginUser() {
		if(this.loginUser == null){
			this.loginUser = new User();
		}
		return loginUser;
	}
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	
	public User getRegisterUser() {
		if(this.registerUser == null){
			this.registerUser = new User();
		}
		return registerUser;
	}
	public void setRegisterUser(User registerUser) {
		this.registerUser = registerUser;
	}
	public String getGreeting(){
		return "Hello " + (name == null? "Guest" : name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String login()
	{
		String view = null;
		if("admin".equals(loginUser.getUsername()) && "admin".equals(loginUser.getPassword())){
			view = "welcome";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login failed. Please try again"));
		}
		
		return view;
	}
	
	public String register()
	{
		String view = "login?faces-redirect=true";
		System.out.println("Register User: "+registerUser);
		return view;
	}
}
