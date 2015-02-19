/**
 * 
 */
package sivalabs.app.web.viewmodels

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

import sivalabs.app.entities.Group

/**
 * @author Siva
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class GroupsModel
{
	boolean success = true;
	List<GroupModel> data = [];
	public GroupsModel(){
		
	}
	public GroupsModel(List<Group> groups)
	{
		if(groups)
		{
			groups.each { g ->
				data.add(new GroupModel([
					"id": g.id,
					"name": g.name					
					]));
			}
		}
	}
}
