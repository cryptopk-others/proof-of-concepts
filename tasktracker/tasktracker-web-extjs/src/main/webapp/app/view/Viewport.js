Ext.define('MyApp.view.Viewport',{
	extend: 'Ext.container.Viewport',
	layout: 'border',
	
	
	initComponent : function(){
		var me = this;
		me.items = [
		            	me.getHeaderPanel(),
		            	me.getFooterPanel(),
		            	me.getNavigationPanel(),
		            	me.getCenterPanel()
		            ];
		me.callParent();
	},
	
	getHeaderPanel : function()
	{
		return {
			region: 'north',
			html: '<h1>User Management</h1>',
			height: 80
			
		};
	},
	
	getFooterPanel : function()
	{
		return {
			region: 'south',
			html: 'www.SivaLabs.in Copyright @ 2014',
			height: 30
		};
	},
	
	getNavigationPanel : function()
	{
		return {
			region: 'west',
			title: 'Navigation Menu',
			width: 250,
			collapsible: true,
			split: true,
			titleCollapse: true,
			html: 'Navigation'
			/*
			xtype: 'container',
			layout: 'vbox',
			items: [
			     {
			    	 xtype: 'button',
			    	 text: 'Users'
			     },
			     {
			    	 xtype: 'button',
			    	 text: 'Roles'
			     },
			     {
			    	 xtype: 'button',
			    	 text: 'Contacts'
			     }
			     
			        
			]*/
		};
	},
	
	getCenterPanel : function()
	{
		return {
			region: 'center',
			//html: 'Content'
			xtype: 'userscnt'
		};
	}
});