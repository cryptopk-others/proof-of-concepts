/**
 * 
 */
package com.sivalabs.buzz.core.entity;

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
@Table(name="MESSAGES")
@Data
@ToString(exclude={"createdBy"})
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude={"createdBy"})
@JsonIgnoreProperties({"createdBy"})
public class Message
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false, length=250)
	private String content;
	@Column(name="created_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn = new Date();
	@ManyToOne
	@JoinColumn(name="created_by", nullable=false)
	private User createdBy;
	
}
