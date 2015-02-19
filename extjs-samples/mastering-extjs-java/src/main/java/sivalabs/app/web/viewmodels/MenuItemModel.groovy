/**
 * 
 */
package sivalabs.app.web.viewmodels

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement

/**
 * @author Siva
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class MenuItemModel 
{
	int id;
	String text;
	String iconCls;
	int parentId;
	String className;
	boolean leaf;
	//@XmlElementWrapper(name="items")
	//@XmlElement(name="item")
	List<MenuItemModel> items = []
}
