/**
 * 
 */
package com.demo;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * @author skatam
 *
 */
@Named
@Scope("session")
public class UserManagedBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private User loginUser;
	private User registerUser;
	private List<User> users;
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	void init()
	{
		this.users = userService.getUsers();
	}
	
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
	
	public List<User> getUsers() {
		System.out.println("------getUsers---");
		return users;
	}
	
	public String login()
	{
		String view = null;
		if(userService.login(loginUser)){
			view = "welcome";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login failed. Please try again"));
		}
		
		return view;
	}
	
	public String register()
	{
		String view = "login?faces-redirect=true";
		userService.register(registerUser);
		return view;
	}
}
