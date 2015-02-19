/**
 * 
 */
package sivalabs.app.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "Country")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Country implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	@JsonProperty("country_id")
	private Integer id;
	@Column(name = "country")
	@JsonProperty("country")
	private String country;
	@Column(name = "last_update")
	@JsonProperty("last_update")
	@Temporal(TemporalType.TIMESTAMP)
	//@JsonSerialize(using=CustomJsonDateSerializer.class)
	//@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date lastUpdate;
	
	@OneToMany(mappedBy="country")
	private Set<City> cities = new HashSet<>();
	
	public Country() {
	}

	public Country(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
