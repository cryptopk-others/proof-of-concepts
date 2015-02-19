Ext.onReady(function() {

	var panel = Ext.create('Ext.panel.Panel', {
		title : 'Panel Header',
		width : 500,
		height : 200,
		bodyPadding : 10,
		html : 'Panel Content',
		dockedItems : [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				xtype : 'button',
				text : 'Click me'
			}, '->', 'Docked toolbar at the top' ]
		}
		/*,
		{
			xtype: 'toolbar',
			dock: 'bottom',
			items: [{
				xtype: 'button',
				text: 'Click me'
				}, '->', 'Docked toolbar at the bottom']
		}
		*/
		],
		/*
		fbar: ['Docked toolbar at the bottom (on footer)', {
			xtype: 'button',
			text: 'Click Me'
			}],
		*/
		lbar: ['lbar'],
		rbar: ['rbar'],
		tbar: ['tbar'],
		bbar: ['bbar'],
			
		renderTo : Ext.getBody(),
		style : 'margin: 50px'
	});
	
	panel.addDocked({
		dock: 'top',
		xtype: 'toolbar',
		items: [{
		text: 'button'
		}]
		});

});