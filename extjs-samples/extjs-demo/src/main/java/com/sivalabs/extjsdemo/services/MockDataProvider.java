/**
 * 
 */
package com.sivalabs.extjsdemo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sivalabs.extjsdemo.web.rest.model.DataGrid;

/**
 * @author Siva
 *
 */
public class MockDataProvider {

	public static DataGrid getUsersDataGrid() {
		DataGrid dg = new DataGrid();
		List<String> headers = new ArrayList<>();
		headers.add("Id");
		headers.add("Name");
		headers.add("Email");
		dg.setHeaders(headers );
		List<Map<String, String>> records = new ArrayList<>();
		
		Map<String, String> r1 = new HashMap<>();		
		r1.put("id", "1");
		r1.put("name", "Name1");
		r1.put("email", "Email 1");
		
		Map<String, String> r2 = new HashMap<>();		
		r2.put("id", "2");
		r2.put("name", "Name2");
		r2.put("email", "Email 2");
		
		records.add(r1);
		records.add(r2);
		
		dg.setRecords(records );
		return dg;
	}

	public DataGrid getProjectsDataGrid() {
		DataGrid dg = new DataGrid();
		
		return dg;
	}

}
