package sivalabs.app.web.viewmodels

import org.springframework.web.multipart.commons.CommonsMultipartFile

class UserModel
{
	int id;
	String name
	String userName
	String email
	String picture
	int groupId
	CommonsMultipartFile  pictureImage
}
