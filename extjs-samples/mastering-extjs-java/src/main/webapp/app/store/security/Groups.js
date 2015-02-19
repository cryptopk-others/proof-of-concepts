Ext.define('Packt.store.security.Groups', {
	extend : 'Ext.data.Store',
	requires : [ 'Packt.model.security.Group' ],
	model : 'Packt.model.security.Group',
	storeId : 'groupStore', // #1
	autoLoad: true,
	proxy : {
		type : 'ajax',
		url : 'rest/security/group',
		reader : {
			type : 'json',
			root : 'data'
		}
	}
});