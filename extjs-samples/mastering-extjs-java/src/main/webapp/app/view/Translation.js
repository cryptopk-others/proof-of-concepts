Ext.define('Packt.view.Translation', {
	extend : 'Ext.button.Split', // #2
	alias : 'widget.translation', // #1
	//text: 'Language',
	//showText: true,
	menu : Ext.create('Ext.menu.Menu', { // #3
		items : [ {
			xtype : 'menuitem', // #4
			iconCls : 'en',
			text : 'English'
		}, {
			xtype : 'menuitem', // #5
			iconCls : 'es',
			text : 'Español'
		}, {
			xtype : 'menuitem', // #6
			iconCls : 'pt_BR',
			text : 'Português'
		} ]
	})
});