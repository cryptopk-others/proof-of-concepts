/**
 * 
 */
package sivalabs.app.web.viewmodels;

/**
 * @author katsi02
 *
 */
public class StaticDataModel<T> 
{
	private String entity;
	private T data;
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
