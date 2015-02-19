/**
 * 
 */
package sivalabs.app.web.viewmodels

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import sivalabs.app.entities.Menu;

/**
 * @author Siva
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class MenuModel 
{
	@XmlElement(name="items")
	List<MenuItemModel> items = []
	
	static void main(String[] args)
	{
		MenuModel m = new MenuModel()
		m.populate(null);
	}
	void populate(Set<Menu> menus)
	{
		if(menus)
		{
			menus.each { menu ->
				
				//System.err.println (menu.parent);
				if(!menu.parent){
					
					MenuItemModel moduleMenu = new MenuItemModel([
						"id": menu.id,
						"text": menu.text,
						"iconCls": menu.iconCls,
						//"parentId": null,
						//"className": null,
						"leaf": false
						]);
					
					Set<Menu> menuItems = menu.childMenus;
						menuItems.each { childMenu ->
							MenuItemModel m2 = new MenuItemModel([
								"id": childMenu.id,
								"text": childMenu.text,
								"iconCls": childMenu.iconCls,
								"parentId": childMenu.parent.id,
								"className": childMenu.className,
								"leaf": true
								]);
					
							moduleMenu.items.add(m2);
						}
					
					this.items.add(moduleMenu);
				}
				
			}
		}
		/*
		MenuItemModel m1 = new MenuItemModel([
			"id": 1,
			"text": "menu1",
			"iconCls": "menu_admin",
			//"parentId": null,
			//"className": null,
			"leaf": false
			]);
		
		MenuItemModel m2 = new MenuItemModel([
			"id": 2,
			"text": "menu11",
			"iconCls": "menu_groups",
			"parentId": 1,
			"className": "panel",
			"leaf": true
			]);
		
		MenuItemModel m3 = new MenuItemModel([
				"id": 3,
				"text": "menu12",
				"iconCls": "menu_users",
				"parentId": 1,
				"className": "panel",
				"leaf": true
			]);
		
		MenuItemModel m4 = new MenuItemModel([
			"id": 4,
			"text": "menu13",
			"iconCls": "menu_profile",
			"parentId": 1,
			"className": "panel",
			"leaf": true
		]);
	
	
	
	m1.items = [m2,m3,m4] ;
	
	this.items = [m1];
	*/
	}
}
