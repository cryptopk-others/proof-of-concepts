Ext.define('MyApp.view.UsersGrid',{
	extend: 'Ext.grid.Panel',
	alias: 'widget.usersgrid',
	store: 'MyApp.store.UserStore',
	title: 'Users Grid',
	itemId: 'usersGrid',
	//height: 200,
    width: 400,
	//layout:'fit',
	forceFit: true,
	columns : [
	           {text: 'Id', dataIndex: 'id'},
	           {text: 'FirstName', dataIndex: 'firstName'},
	           {text: 'LastName', dataIndex: 'lastName'},
	           {text: 'Email', dataIndex: 'email'},
	           {text: 'DOB', dataIndex: 'dob',  renderer : Ext.util.Format.dateRenderer('m/d/Y')}
	           ],
    
    dockedItems: [{
    	xtype: 'toolbar',
    	dock: 'top',
    	items: [{
    		xtype: 'button',
    		text: 'Add',
    		handler: function(){
    			var userWin = Ext.widget('createuser');
    			userWin.show();
    		}
    	}]
    }],
	initComponent : function(config)
	{
		var me = this;
		
		me.callParent();
	},
	
	listeners: {
		
		afterrender : function(view, opts){
			//var me = this;
			//view.getStore().load();
		},
		
		itemclick:function (view, record, htmlItem, index,eventObject, opts) {
			var form = Ext.ComponentQuery.query('#userForm')[0];	
			form.loadRecord(record);
		}
	}
				
	
});