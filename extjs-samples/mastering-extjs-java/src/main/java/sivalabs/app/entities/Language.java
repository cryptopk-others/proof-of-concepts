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
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author katsi02
 * 
 */
@Entity
@Table(name = "Language")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	@JsonProperty("language_id")
	private Integer id;
	@Column(name = "name")
	@JsonProperty("name")
	private String name;
	@JsonProperty("last_update")
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	//@JsonSerialize(using=CustomJsonDateSerializer.class)
	//@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date lastUpdate;

	public Language() {
	}

	public Language(Integer id) {
		this.id = id;
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

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
