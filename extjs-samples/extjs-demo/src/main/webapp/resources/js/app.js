Ext.onReady(function(){
   // Ext.Msg.alert("Hi","Hello ExtJS");
	Ext.create('Ext.panel.Panel',{
		renderTo: Ext.getBody(),
		title: 'Main Panel',
		width: 500,
		height: 300,
		items: [
		        {
		        	xtype: 'CustomerGrid',
		        	url: 'getUsersJSON.json'
		        }
		        
		]
		
	});
	/*
	Ext.create('Ext.form.Panel',{
		renderTo: Ext.getBody(),
		width: 500,
		height: 300,
		title: 'User Form',
		items: [
		     {
		    	 xtype: 'textfield',
		    	 name:'name',
		    	 fieldLabel: 'Name',
		    	 itemId: 'name'
		     },
		     {
		    	 xtype: 'textfield',
		    	 name:'email',
		    	 fieldLabel: 'Email',
		    	 itemId: 'email'
		     },
		     {
		    	 xtype: 'textfield',
		    	 name:'phone',
		    	 fieldLabel: 'Phone',
		    	 itemId: 'phone'
		     }
		],
		buttons: [
		     {
		    	 text: 'Search',
		    	 handler: function(){
		    		 Ext.create('Ext.window.Window', {
		    			    title: 'Hello',
		    			    height: 200,
		    			    width: 400,
		    			    layout: 'fit',
		    			    items: [  // Let's put an empty grid in just to illustrate fit layout
		    			        {
		    			        	xtype: 'WebServiceLookup'
		    			        }
		    			    ]
		    			}).show();
		    	 }
		     }
		          
		]
	});
	
	*/
	
	
	
});