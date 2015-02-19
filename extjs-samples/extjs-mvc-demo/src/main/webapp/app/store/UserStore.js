Ext.define('MyApp.store.UserStore',{
	extend: 'Ext.data.Store',
	model: 'MyApp.model.User',
	//storeId: 'UserStore',
	
	proxy: {
		type: 'ajax',
	    url : 'rest/users/',
	    
	    reader: {
	        type: 'json',
	        successProperty: 'status',
	        root: 'data'
	       // totalProperty: 'total'
	    }
    }
    ,autoLoad: true
    /*
	data : [
		        { id: '1',name: 'Siva1',email: 'siva1@gmail.com',dob: '1983-06-25' },
		        { id: '2',name: 'Siva2',email: 'siva2@gmail.com',dob: '1983-06-25'},
		        { id: '3',name: 'Siva3',email: 'siva3@gmail.com',dob: '1983-06-25'}	        	        
	        ],
    proxy: {
        type: 'memory',
        reader: {
            type: 'json'
           // root: 'items'
        }
    }
    */
});