/**
 * 
 */
package com.sivalabs.buzz.core.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Siva
 *
 */
@Entity
@Table(name="ROLES")
@Data
@ToString(exclude={"users"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude={"users"})
@JsonIgnoreProperties({"users"})
public class Role
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false)
	private String name;
	
	@ManyToMany
	@JoinTable(name="USERS_ROLES",
      joinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")},
      inverseJoinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")})
	private Set<User> users = new HashSet<>();
	
}
