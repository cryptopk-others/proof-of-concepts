package sivalabs.app.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Siva
 * 
 */
@Entity
@Table(name = "GROUPS")
public class Group implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Integer id;
	@Column(name = "name", nullable = false, unique = true, length = 50)
	private String name;
	
	@OneToMany(mappedBy="group")
	private Set<User> users = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name = "PERMISSIONS",
    joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "group_id")}, 
    inverseJoinColumns = {@JoinColumn(name = "menu_id", referencedColumnName = "menu_id")})  
	private Set<Menu> menus = new HashSet<>();

	public Group() {
	}
	public Group(Integer id) {
		this.id = id;
	}
	public Group(Integer id, String name) {
		this.id = id;
		this.name = name;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
	
	
}
