
Ext.define('WebServiceLookup',{
	extend: 'Ext.container.Container',
	xtype: 'WebServiceLookup',
	
	constructor: function(config)
	{
		var me = this;
		console.log('1');
		me.callParent(arguments);
	},
	
	initComponent : function()
	{
		var me = this;
		var searchBar = Ext.create('Ext.container.Container',{
			layout: 'hbox',
        	items : [
        	         {
        	        	 xtype: 'textfield',
        	        	 name: 'username'
        	        	 
        	         },
        	         {
        	        	 xtype: 'button',
        	        	 text: 'Search',
        	        	 //renderTo: Ext.getBody(),
        	        	 handler: function() {
        	        	     alert('You clicked the button!');
        	        	 }
        	         }
        	         
        	         ]
		});
		
		var userStore = Ext.create('Ext.data.Store', {
			
			/*
		    fields:['name', 'email', 'phone'],
		    data:{'items':[
		        { 'name': 'Lisa',  "email":"lisa@simpsons.com",  "phone":"555-111-1224"  },
		        { 'name': 'Bart',  "email":"bart@simpsons.com",  "phone":"555-222-1234" },
		        { 'name': 'Homer', "email":"home@simpsons.com",  "phone":"555-222-1244"  },
		        { 'name': 'Marge', "email":"marge@simpsons.com", "phone":"555-222-1254"  }
		    ]},
		    proxy: {
		        type: 'memory',
		        reader: {
		            type: 'json',
		            root: 'items'
		        }
		    },
		    */
			proxy: {
		         type: 'ajax',
		         url: 'resources/js/grid-data.json',
		         reader: {
		             type: 'json',
		             root: 'users'
		         }
		     },
		     autoLoad: true,
		    listeners: {
		    	'metachange': function(store, meta) {
		    		var grid = Ext.ComponentQuery.query('#userGridId')[0];
		    		//alert(grid);
		    		grid.reconfigure(store, meta.columns);
		        }
		    }
		});

		var userGrid = Ext.create('Ext.grid.Panel', {
		    itemId: 'userGridId',
			title: 'Users Grid',
		    store: userStore,
		    columns: [],
		    /*
		    columns: [
		        { text: 'Name',  dataIndex: 'name' },
		        { text: 'Email', dataIndex: 'email', flex: 1 },
		        { text: 'Phone', dataIndex: 'phone' }
		    ],
		    */
		    height: 200,
		    width: 400,
		    listeners: {
		    	
		        'itemclick': function( grid, record, item, index, e, eOpts) {
		           // console.log(grid, record, item, index, e, eOpts);
		           // alert(1);
		        	Ext.ComponentQuery.query('#name')[0].setValue(record.get('name'));
		        	Ext.ComponentQuery.query('#email')[0].setValue(record.get('email'));
		        	Ext.ComponentQuery.query('#phone')[0].setValue(record.get('phone'));
		        	me.ownerCt.hide();
		        }
		    }
		});
		
		
		me.items = [
		            {
		            	xtype: 'panel',
		            	layout: 'vbox',
		            	items : [searchBar,userGrid]
		            }
		            
		            ];
		
		
		me.callParent(arguments);
	}
});