/**
 * Copyright 2016 SivaLabs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

/**
 * @author Siva
 *
 */
public class Main
{
	static String urlString = "http://localhost:8983/solr/mycore";
	static SolrClient solr = null;
	
	public static void main(String[] args) throws Exception
	{
		solr = new HttpSolrClient(urlString);
		
		//deleteAll();
		
		//storeProducts(); readAll();
		readFacets();
		
		solr.close();
	}
	
	static void readFacets() throws Exception
	{
		SolrQuery query = new SolrQuery();
		String mQueryString = "*:*";
		query.setQuery(mQueryString );
		query.addFilterQuery("brand:LG");
		query.setFacet(true);
		query.addFacetField("brand", "category");
		
		QueryResponse response = solr.query(query);
		List<FacetField> facetFields = response.getFacetFields();
		
		for (FacetField facetField : facetFields)
		{
			System.err.println(facetField.getName()+":"+facetField.getValueCount());
			List<Count> values = facetField.getValues();
			for (Count count : values)
			{
				System.err.println(count.getName()+":"+count.getCount());
			}
		}
		
		SolrDocumentList list = response.getResults();
		//System.out.println(list);
		for (SolrDocument solrDocument : list)
		{
			//Object code = solrDocument.get("code");
			Map<String, Collection<Object>> fieldValuesMap = solrDocument.getFieldValuesMap();
			System.out.println("-->"+fieldValuesMap);
		}
	}
	
	static void storeProducts() throws IOException, SolrServerException
	{
		List<Product> products = getProductsFromCSV();
		for (Product product : products)
		{
			System.err.println(product);
			
			SolrInputDocument document = new SolrInputDocument();
			document.addField("id", product.getCode());
			document.addField("code", product.getCode());
			document.addField("title", product.getTitle());
			document.addField("description", product.getDescription());
			document.addField("price", product.getPrice());
			document.addField("brand", product.getBrand());
			document.addField("category", product.getCategory());
			
			UpdateResponse response = solr.add(document);
			System.out.println("Response Status: "+response.getStatus());
			solr.commit();
			
		}
		
	}

	static void deleteAll() throws Exception
	{
		SolrQuery sq = new SolrQuery("*:*");
		solr.deleteByQuery(sq.getQuery());
		solr.commit();
	}
	static void readAll() throws Exception
	{
		SolrQuery query = new SolrQuery();
		String mQueryString = "*:*";
		query.setQuery(mQueryString );
		QueryResponse response = solr.query(query);
		SolrDocumentList list = response.getResults();
		//System.out.println(list);
		for (SolrDocument solrDocument : list)
		{
			//Object code = solrDocument.get("code");
			Map<String, Collection<Object>> fieldValuesMap = solrDocument.getFieldValuesMap();
			System.out.println(fieldValuesMap);
		}
	}
	
	static List<Product> getProductsFromCSV() throws IOException
	{
		List<Product> products = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream("products.txt")));
		String str;
		while( (str= reader.readLine()) != null){
			if(str.trim().length()>0 && !str.trim().startsWith("#")){
				String[] parts = str.split(",");
				Product product = new Product();
				if(parts.length>0) product.setCode(parts[0].trim());
				if(parts.length>1) product.setTitle(parts[1].trim());
				if(parts.length>2) product.setDescription(parts[2].trim());
				if(parts.length>3) product.setPrice(new BigDecimal(parts[3].trim()));
				if(parts.length>4) product.setBrand(parts[4].trim());
				if(parts.length>5) product.setCategory(parts[5].trim());
				
				products.add(product);
			}
		}
		return products;
	}
}
