/**
 * 
 */
package sivalabs.app.web.viewmodels

import javax.xml.bind.annotation.XmlRootElement;

import sivalabs.app.entities.User;

/**
 * @author Siva
 *
 */
@XmlRootElement
class UsersModel
{
	boolean success = true;
	List<UserModel> data = [];
	
	public UsersModel(List<User> users)
	{
		if(users)
		{
			users.each { u ->
				data.add([
					"id": u.id,
					"name": u.name,
					"userName": u.userName,
					"email": u.email,
					"picture": u.picture,
					"groupId": u.group.id
					]);
			}
		}
	}
}
