Ext.define('MyApp.view.CreateUser',{
	extend: 'Ext.window.Window',
	alias: 'widget.createuser',
	title: 'New User',

	initComponent : function(){
		var me = this;
		
		var userForm = me.getUserForm();
		me.items = [userForm];
		me.callParent();
	},
	
	getUserForm: function()
	{
		var me = this;
		var userForm = Ext.create('Ext.form.Panel',{
			defaults:{
				xtype: 'textfield',
				//allowBlank:false,
				cls: 'field-margin',
				anchor:'100%'
			},
			items : [
			         
						/*{
							 
							 fieldLabel: 'Id',
							 name: 'id'
						},*/
						{
							 fieldLabel: 'FirstName',
							 name: 'firstName',
							 allowBlank:false
							 
						},
						{
							 fieldLabel: 'LastName',
							 name: 'lastName'
						},
						{
							 fieldLabel: 'Email',
							 name: 'email',
							 allowBlank:false
						},
						{
							 fieldLabel: 'Password',
							 name: 'password',
							 inputType: 'password',
							 allowBlank:false 
						},
						{
							 xtype: 'datefield',
							 fieldLabel: 'DOB',
							 name: 'dob'
						}  
			         ],
			   buttons: [
			             
			             {
			            	 text: 'Save',
			            	 handler: function(){
			            		 if(userForm.isValid())
			            		 {
			            			 me.saveUser(userForm);
			            			 me.hide();
			            			 var grid = Ext.ComponentQuery.query('#usersGrid')[0];
			            			 grid.getStore().load();
			            		 }
			            		 else
			            		 {
			            			 Ext.Msg.alert('Error','Please enter all mandatory fields');
			            		 }
			            	 },
			            	 scope: me
			             },
			             {
			            	 text: 'Close',
			            	 handler: function(){
			            		 me.hide();
			            	 },
			            	 scope: me
			             }
			             ]
		});
		
		return userForm;
	},
	
	saveUser : function(formPanel)
	{
		console.log('save');
		var formData = Ext.encode(formPanel.getValues());
		
		Ext.Ajax.request({
		            url: 'users/',
		            method: 'POST',
		            waitTitle: 'Connecting',
		            waitMsg: 'Sending data...',
		            jsonData: formData
		            
                });		
		
	}
});