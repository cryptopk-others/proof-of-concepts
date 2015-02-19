package com.sivalabs.ebuddy.config;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class CustomJsonObjectMapper extends ObjectMapper{
	
	private static final long serialVersionUID = 1L;

	public CustomJsonObjectMapper() {
		//SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		//getSerializationConfig().with(df);
		//getDeserializationConfig().with(df);
		
		SimpleModule testModule = new SimpleModule("MyModule");
		testModule.addSerializer(Date.class, new JsonDateSerializer());
		testModule.addDeserializer(Date.class, new JsonDateDeserializer());
		
		registerModule(testModule);
	}
	
	
}
