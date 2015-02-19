package sivalabs.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 * 
 */
@Entity
@Table(name = "USERS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	@Column(name = "username", nullable = false, unique = true,  length = 50)
	private String userName;
	@Column(name = "password", nullable = false, length = 50)
	private String password;
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	@Column(name = "picture")
	private String picture;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group group;

	public User() {
	}
	public User(Integer id, String name, String userName, String password, String email) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public User(Integer id, String name, String userName, String password,
			String email, String picture) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.picture = picture;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	


}
