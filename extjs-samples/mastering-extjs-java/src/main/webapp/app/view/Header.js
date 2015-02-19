Ext.define('Packt.view.Header', {					
	extend : 'Ext.toolbar.Toolbar', // #1
	alias : 'widget.appheader', // #2
	height : 30, // #3
	ui : 'footer', // #4
	style : 'border-bottom: 4px solid #4c72a4;', // #5
	items : [
	         {
				xtype : 'label', // #6
				html : '<div id="titleHeader">Video Store Manager<span style="font-size:12px;"> - Mastering Ext JS</span></div>'
			}, {
				xtype : 'tbfill' // '->'
			},
			{
				xtype: 'translation'
			},
			{
				xtype : 'tbseparator' // '-'
			}, {
				xtype : 'button', // #9
				text : 'Logout',
				itemId : 'logout',
				iconCls : 'logout'
			} 
			]
});