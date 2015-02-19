/**
 * 
 */
package com.sivalabs.ebuddy.config;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sivalabs.ebuddy.utils.Constants;

/**
 * @author Siva
 *
 */
public class JsonDateDeserializer extends JsonDeserializer<Date>{

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.APP_DATE_FORMAT);
		String dateStr = jp.getText().trim();
		if(dateStr.equals("")){
			return null;
		}
		try {
		return	dateFormat.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	

}
