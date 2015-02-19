/**
 * 
 */
package sivalabs.app.config;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author Siva
 *
 */
public class JsonDateSerializer extends JsonSerializer<Date>{

	public static final String APP_DATE_FORMAT = "MM/dd/yyyy";
	
	@Override
	public void serialize(Date date, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		if(date == null)
		{
			jgen.writeString("");
		}
		else
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDate = dateFormat.format(date);
			jgen.writeString(formattedDate);
		}
	}

}
