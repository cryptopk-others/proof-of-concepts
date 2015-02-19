/**
 * 
 */
package sivalabs.app.web.viewmodels

/**
 * @author Siva
 *
 */
class SampleResponses {
	
	def menuJson = '''
	{
	"items": [{
		"id": "1",
		"text": "menu1",
		"iconCls": "menu_admin",
		"parent_id": null,
		"className": null,
		"leaf": false,
		"items": [{
		"id": "2",
		"text": "menu11",
		"iconCls": "menu_groups",
		"parent_id": "1",
		"className": "panel",
		"leaf": true
		}, {
		"id": "3",
		"text": "menu12",
		"iconCls": "menu_users",
		"parent_id": "1",
		"className": "panel",
		"leaf": true
		}, {
		"id": "4",
		"text": "menu13",
		"iconCls": "menu_profile",
		"parent_id": "1",
		"className": "panel",
		"leaf": true
		}]
		}]
	}
	'''
}
