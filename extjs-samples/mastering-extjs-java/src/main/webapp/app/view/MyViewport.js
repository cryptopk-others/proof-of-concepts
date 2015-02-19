Ext.define('Packt.view.MyViewport', {					
	extend : 'Ext.container.Viewport', // #1
	alias : 'widget.mainviewport', // #2
	requires : [ 'Packt.view.Header', 'Packt.view.MainPanel'
	],
	layout : {
		type : 'border' // #4
	},
	items : [
			{
				xtype: 'mainmenu',
				width: 185,
				collapsible: true,
				region: 'west'//,
				//style: 'background-color: #8FB488;'
			},
			{
				xtype : 'appheader', // #6
				region : 'north'
			},
			{
				xtype: 'mainpanel',
				region: 'center'
			},
			{
				xtype : 'container', // #8
				region : 'south',
				height : 30,
				style : 'border-top: 1px solid #4c72a4;',
				html : '<div id="titleHeader"><center><span style="fontsize:10px;">Mastering ExtJS book - Loiane Groner - http://packtpub.com</span></center></div>'
			} 
			]
});