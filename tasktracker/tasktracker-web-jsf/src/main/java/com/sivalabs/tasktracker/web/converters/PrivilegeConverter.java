/**
 * 
 */
package com.sivalabs.tasktracker.web.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.sivalabs.tasktracker.entities.Privilege;

/**
 * @author Siva
 *
 */
@FacesConverter(value="privilegeConverter", forClass=Privilege.class)
public class PrivilegeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		if (value==null || value.trim().equals("")) {  
            return null;  
        } else {  
            try {  
            	int id = Integer.parseInt(value);
            	List<Privilege> privileges = getPrivileges();
            	for (Privilege privilege : privileges) {
					if(id == privilege.getId()){
						return privilege;
					}
				}
  
            } catch(NumberFormatException exception) {  
            	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Privilege");
                throw new ConverterException(msg);  
            }  
        }  
  
        return null; 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if (value == null || value.equals("")) {  
            return "";  
        } else {  
            return String.valueOf(((Privilege) value).getId());
        } 
	}

	public static List<Privilege> getPrivileges()
	{
		List<Privilege> sourcePrivileges = new ArrayList<>();
		sourcePrivileges.add(new Privilege(1,"CREATE_PROJECT"));
		sourcePrivileges.add(new Privilege(2,"CREATE_USER"));
		sourcePrivileges.add(new Privilege(3,"DISABLE_USER"));
		sourcePrivileges.add(new Privilege(4,"CREATE_WORKITEM"));
		sourcePrivileges.add(new Privilege(5,"ASSOGN_WORKITEM"));
		
		return 	sourcePrivileges;	
	}
}
