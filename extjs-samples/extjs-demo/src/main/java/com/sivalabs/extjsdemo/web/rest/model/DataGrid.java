/**
 * 
 */
package com.sivalabs.extjsdemo.web.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Siva
 *
 */
@XmlRootElement(name="Response")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataGrid 
{
	@XmlElementWrapper(name="headers")
	@XmlElement(name="header")
	private List<String> headers = new ArrayList<>();
	
	@XmlElementWrapper(name="data")
	//@XmlElement(name="record")
	private List<Map<String, String>> records = new ArrayList<>();
	
	public List<String> getHeaders() {
		return headers;
	}
	public void setHeaders(List<String> headers) {
		this.headers = headers;
	}
	public List<Map<String, String>> getRecords() {
		return records;
	}
	public void setRecords(List<Map<String, String>> records) {
		this.records = records;
	}
	
	
}
