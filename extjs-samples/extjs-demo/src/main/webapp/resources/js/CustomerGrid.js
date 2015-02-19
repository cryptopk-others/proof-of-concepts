
Ext.define('CustomerGrid',{
	extend: 'Ext.container.Container',
	xtype: 'CustomerGrid',
	height: 800,
	width: 500,
	//layout: 'vbox',
	
	constructor: function(config)
	{
		var me = this;
		console.log('constructor');
		//me.curStore = me.getMyStore();
		me.url = config.url;
		me.callParent(arguments);
	},
	
	initComponent: function()
	{
		var me = this;
		console.log('initComponent');
		var searchPanel = {
				xtype: 'container',
				layout: 'hbox',
				width: 300,
				items:[
				       {
				    	   xtype: 'textfield',
				    	   name: 'searchCriteria',
				    	   itemId: 'searchCriteria'
				       },
				       {
				    	   xtype: 'button',
				    	   text: 'Search',
				    	   handler: function()
				    	   {
				    		   //alert('search');
				    		   var payload ={
				    				   query: Ext.ComponentQuery.query('#searchCriteria')[0].getValue()
				    		   };
				    		   me.performSearch(payload);
				    	   },
				    	   scope: me
				       }
				]
		};
		
		
		me.items = [
		            {
		            	xtype: 'container',
		            	itemId: 'mainContainer',
		            	//layout: 'column',
		            	items : [searchPanel]
		            }
		            
		            ];
		
		me.callParent(arguments);
		
		var payload ={
				   query: Ext.ComponentQuery.query('#searchCriteria')[0].getValue()
		};
		me.performSearch(payload);
	},
	
	
	
	performSearch : function(payload)
	{
		var me = this;
		console.log('performSearch :'+payload.query);
		console.log('URL :'+me.url);
		//var grid = Ext.ComponentQuery.query('#userGridId')[0];
		Ext.create('Ext.data.Store',{
			autoLoad: true,
			proxy: {
		         type: 'ajax',
		         url: me.url,
		         reader: {
		             type: 'json'
		         }
		     },
		     listeners: {
		    	 'load' : function(store, records, successful, eOpts) {
		    		 me.buildGridComponents(store);
		    	 },
		    	 scope: me
		     }
			
		});
	},
	
	buildGridComponents : function(store){
		var me = this;
		var jsonData = store.proxy.reader.jsonData;
		 console.log('Store loaded:'+jsonData);
		 //console.log(store.getAt(0).raw);
		 var fields = [];
		 var data = jsonData.records;
		 var rec1 = data[0];
		 for(var f in rec1)
		 {
			 fields.push(f);
		 }
		 var columns = [];
		 
		 var headers = jsonData.headers;
		 for(var header in headers)
		 {
			 console.log(header+":"+headers[header]);
			 columns.push({
				 text: headers[header],
				 dataIndex: headers[header].toLowerCase()
			 });
		 }
		 
		 var storeObj = Ext.create('Ext.data.Store',{
			 fields: fields,
			 data: data,
			 autoLoad: true
		 });
		 
		 var gridObj = Ext.create('Ext.grid.Panel',{
			 title: 'My Grid',
			 store: storeObj,
			 columns: columns
		 });
		 
		 var mainContainer = Ext.ComponentQuery.query('#mainContainer')[0];
		 console.log(mainContainer.items);
		 mainContainer.add(gridObj);
		 console.log(mainContainer.items);
		 //mainContainer.doLayout();
		 //gridObj.render(Ext.getBody());
		 
		// me.superclass.initComponent.call(this);
	}
	
});