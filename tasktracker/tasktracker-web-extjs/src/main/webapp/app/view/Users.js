Ext.define('MyApp.view.Users',{
	extend: 'Ext.container.Container',
	alias: 'widget.userscnt',
	layout: 'hbox',
	//frame: false,
	
	initComponent : function(config)
	{
		var me = this;
		
		//me.items = [];
		me.items = [me.getUsersGrid(), me.getUserForm()];
		
		me.callParent(arguments);
	},
	
	getUsersGrid : function(){
		var userGrid = {
				xtype: 'usersgrid',
				//width: 500,
				flex: .6,
				style: 'margin: 10px'
				//html: 'Panel'
		};
		return userGrid;
	},
	
	getUserForm : function(){
		var userForm = {
				xtype: 'userdetails',
				//width: 500,
				flex: .4,
				style: 'margin: 10px'
				//html: 'Panel'				
				};
		return userForm;
	},
});