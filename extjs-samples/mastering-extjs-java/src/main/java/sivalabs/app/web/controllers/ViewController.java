/**
 * 
 */
package sivalabs.app.web.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sivalabs.app.entities.Actor;
import sivalabs.app.entities.Category;
import sivalabs.app.entities.City;
import sivalabs.app.entities.Country;
import sivalabs.app.entities.Group;
import sivalabs.app.entities.Language;
import sivalabs.app.entities.Menu;
import sivalabs.app.entities.User;
import sivalabs.app.repositories.ActorRepository;
import sivalabs.app.repositories.CategoryRepository;
import sivalabs.app.repositories.CityRepository;
import sivalabs.app.repositories.CountryRepository;
import sivalabs.app.repositories.GroupRepository;
import sivalabs.app.repositories.LanguageRepository;
import sivalabs.app.services.UserService;
import sivalabs.app.web.viewmodels.GenericResponse;
import sivalabs.app.web.viewmodels.GroupsModel;
import sivalabs.app.web.viewmodels.MenuModel;
import sivalabs.app.web.viewmodels.StaticDataModel;

/**
 * @author Siva
 *
 */
@RestController
public class ViewController 
{

	@Autowired
	UserService userService;
	
	@Autowired GroupRepository groupRepository;
	//@Autowired StaticDataRepository staticDataRepository;
	@Autowired ActorRepository actorRepository;
	@Autowired CategoryRepository categoryRepository; 
	@Autowired CityRepository cityRepository;
	@Autowired CountryRepository countryRepository;
	@Autowired LanguageRepository languageRepository;
	
	
	
	@RequestMapping(value="menu", produces=MediaType.APPLICATION_JSON_VALUE)
	public MenuModel getMenuJson(@RequestParam("userId")int userId) {
		User user = userService.findUserById(userId);
		Group group = user.getGroup();
		Set<Menu> menus = group.getMenus();
		MenuModel menu = new MenuModel();
		menu.populate(menus);
		return menu;
	}
	
	@RequestMapping(value="security/group", produces=MediaType.APPLICATION_JSON_VALUE)
	public GroupsModel findAllGroups(HttpSession session) {
		GroupsModel groupsModel = new GroupsModel(groupRepository.findAll());
		return groupsModel ;
	}
	
	@RequestMapping(value="staticData/list", produces=MediaType.APPLICATION_JSON_VALUE,params="entity=Category")
	public GenericResponse<Category> staticDataCategory() {
		GenericResponse<Category> genericResponse = new GenericResponse<>();
		genericResponse.setData(categoryRepository.findAll());			
		return genericResponse;
	}
	
	@RequestMapping(value="staticData/list", produces=MediaType.APPLICATION_JSON_VALUE,params="entity=Country")
	public GenericResponse<Country> staticDataCountry() {
		GenericResponse<Country> genericResponse = new GenericResponse<>();
		genericResponse.setData(countryRepository.findAll());			
		return genericResponse;
	}
	
	@RequestMapping(value="staticData/list", produces=MediaType.APPLICATION_JSON_VALUE,params="entity=Language")
	public GenericResponse<Language> staticDataLanguage() {
		GenericResponse<Language> genericResponse = new GenericResponse<>();
		genericResponse.setData(languageRepository.findAll());			
		return genericResponse;
	}
	
	@RequestMapping(value="staticData/list", produces=MediaType.APPLICATION_JSON_VALUE,params="entity=City")
	public GenericResponse<City> staticDataCity() {
		GenericResponse<City> genericResponse = new GenericResponse<>();
		genericResponse.setData(cityRepository.findAll());			
		return genericResponse;
	}
	
	@RequestMapping(value="staticData/list", produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },params="entity=Actor")
	public GenericResponse<Actor> staticDataActor() {
		GenericResponse<Actor> genericResponse = new GenericResponse<>();
		genericResponse.setData(actorRepository.findAll());			
		return genericResponse;
	}
	
	@RequestMapping(value="staticData/create", params="entity=Actor")
	public void createActor(StaticDataModel<Actor> dataModel) {
		System.out.println(dataModel.getEntity()+":"+dataModel.getData());
	}
	
	@RequestMapping(value="staticData/create", params="entity=City")
	public void createCity(StaticDataModel<City> dataModel) {
		System.out.println(dataModel.getEntity()+":"+dataModel.getData());
	}
	
	@RequestMapping(value="staticData/create", params="entity=Country")
	public void createCountry(StaticDataModel<Country> dataModel) {
		System.out.println(dataModel.getEntity()+":"+dataModel.getData());
	}
	
	@RequestMapping(value="staticData/create", params="entity=Category")
	public void createCategory(StaticDataModel<Category> dataModel) {
		System.out.println(dataModel.getEntity()+":"+dataModel.getData());
	}
	
	@RequestMapping(value="staticData/create", params="entity=Language")
	public void createLanguage(StaticDataModel<Language> dataModel) {
		System.out.println(dataModel.getEntity()+":"+dataModel.getData());
	}
}
