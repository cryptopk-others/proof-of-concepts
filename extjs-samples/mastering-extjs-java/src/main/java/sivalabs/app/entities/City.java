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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author katsi02
 *
 */
@Entity
@Table(name = "City")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties({"country"})
public class City implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	@JsonProperty("city_id")
	private Integer id;
	
	@JsonProperty("city")
	@Column(name = "city")
	private String city;
	
	@JsonProperty("last_update")
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	//@JsonSerialize(using=CustomJsonDateSerializer.class)
	//@JsonDeserialize(using=CustomJsonDateDeserializer.class)
	private Date lastUpdate;

	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;
	
	public City() {
	}

	public City(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	@JsonProperty("country_id")
	public int getCountryId() {
		return this.country == null? 0: this.country.getId();
	}
	
}