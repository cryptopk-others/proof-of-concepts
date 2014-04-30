/**
 * 
 */
package com.sivalabs.buzz.core.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name="USERS")
@Data
@ToString(exclude={"roles","messages"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude={"roles","messages"})
@JsonIgnoreProperties({"roles","messages"})
public class User
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="users")
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy="createdBy")
	private List<Message> messages = new ArrayList<>();
}
