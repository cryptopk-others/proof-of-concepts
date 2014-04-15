Ext.define('MyApp.model.User',{
	extend: 'Ext.data.Model',
	fields: [
	         'id','firstName','lastName','email',{name:'dob', type: 'date'}
	         ]
});