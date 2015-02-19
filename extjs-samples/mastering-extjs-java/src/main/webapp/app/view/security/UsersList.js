Ext.define('Packt.view.security.UsersList', {
	extend : 'Ext.grid.Panel',
	alias : 'widget.userslist',
	frame : true,
	store : Ext.create('Packt.store.security.Users'), // #1
	columns : [ {
		width : 150,
		dataIndex : 'userName',
		text : 'Username'
	}, {
		width : 200,
		dataIndex : 'name',
		flex : 1,
		text : 'Name'
	}, {
		width : 250,
		dataIndex : 'email',
		text : 'Email'
	}, {
		width : 150,
		dataIndex : 'groupId',
		text : 'Group',
		renderer : function(value, metaData, record) { // #2
			var groupsStore = Ext.getStore('groupStore');
			//console.log('groupsStore:'+groupsStore);
			var group = groupsStore.findRecord('id', value);
			return group != null ? group.get('name') : value;
		}
	} ]
});