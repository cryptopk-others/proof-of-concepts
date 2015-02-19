Ext.define('Packt.store.security.Users', {
	extend : 'Ext.data.Store',
	requires : [ 'Packt.model.security.User' // #1
	],
	model : 'Packt.model.security.User', // #2
	proxy : {
		type : 'ajax',
		url : 'rest/security/users',
		reader : {
			type : 'json',
			root : 'data'
		}
	}
});