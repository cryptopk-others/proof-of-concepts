Ext.define('MyApp.view.UserDetails',{
	extend: 'Ext.form.Panel',
	alias: 'widget.userdetails',
	title: 'User Form',
	itemId: 'userForm',	
	//width: 300,
	flex: .4,
	style: 'margin: 10px',
	frame:true,
	defaultType:'textfield',
	defaults:{
		xtype: 'textfield',
		//allowBlank:false,
		cls: 'field-margin',
		anchor:'100%'
	},
	initComponent: function(){
		var me = this;
		me.items = 	[
			 {
				 
				 fieldLabel: 'Id',
				 name: 'id'
			 },
			 {
				 fieldLabel: 'FirstName',
				 name: 'firstName'
				 
			 },
			 {
				 fieldLabel: 'LastName',
				 name: 'lastName'
			 },
			 {
				 fieldLabel: 'Email',
				 name: 'email'
			 },
			 {
				 xtype: 'datefield',
				 fieldLabel: 'DOB',
				 name: 'dob'
			 }
		];
		
		me.callParent();
	}
});