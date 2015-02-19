/**
 * 
 */
package sivalabs.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author katsi02
 *
 */

@Entity
@Table(name = "ACTOR")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Actor implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "actor_id")
	@XmlElement(name="actor_id")
	@JsonProperty("actor_id")
	private Integer id;
	
	@XmlElement(name="first_name")
	@JsonProperty("first_name")
	@Column(name = "first_name")
	private String firstName;
	
	@XmlElement(name="last_name")
	@JsonProperty("last_name")
	@Column(name = "last_name")
	private String lastName;
	
	@XmlElement(name="last_update")
	@JsonProperty("last_update")
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	//@JsonSerialize(using=CustomJsonDateSerializer.class)
	//@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date lastUpdate;
	
	public Actor() {
	}
	
	public Actor(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
