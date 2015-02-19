Ext.define('MyApp.controller.User',{
	extend: 'Ext.app.Controller',
	
	init : function(){ //Step 2
		var me = this;
		console.log('Initializing the controller');
		
		this.control({
           /* "companygrid actioncolumn": {
                itemclick: this.handleActionColumn
            }
		*/
        });

	}

});