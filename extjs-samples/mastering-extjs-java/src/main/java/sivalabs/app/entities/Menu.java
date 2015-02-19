/**
 * 
 */
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "MENUS")
public class Menu implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "menu_id")
	private Integer id;
	@Column(name = "text", nullable = false, length = 50)
	private String text;
	private String iconCls;
	private String className;
	
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private  Menu parent;
	
    @OneToMany(mappedBy="parent", fetch=FetchType.EAGER)
    private Set<Menu> childMenus;

    @ManyToMany(mappedBy = "menus",cascade=CascadeType.ALL) 
    private Set<Group> groups = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public Set<Menu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(Set<Menu> childMenus) {
		this.childMenus = childMenus;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
}
