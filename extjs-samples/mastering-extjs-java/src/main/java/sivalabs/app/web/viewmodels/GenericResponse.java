/**
 * 
 */
package sivalabs.app.web.viewmodels;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author katsi02
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GenericResponse<T> 
{
	boolean success = true;
	List<T> data = new ArrayList<>();
	
	public GenericResponse() {
	}
	
	public GenericResponse(List<T> data) {
		this.data = data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<T> getData() {
		return data;
	}
	public boolean isSuccess() {
		return success;
	}
}
