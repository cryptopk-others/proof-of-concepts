/**
 * 
 */
package com.sivalabs.extjsdemo.web.rest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Siva
 *
 */
public class Record {

	private List<Column> columns = new ArrayList<>();

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
	
}
