Ext.define('Packt.controller.Menu', {
	extend : 'Ext.app.Controller',
	models : [ 'menu.Root', 'menu.Item' ],
	stores : [ 'Menu' ],
	views : [ 'menu.Accordion', 'menu.Item' ],
	refs : [ {
		ref : 'mainPanel',
		selector : 'mainpanel'
	} ],
	init : function(application) {
		this.control({
			"mainmenu" : {
				render : this.onPanelRender
			},
			"mainmenuitem" : {
				select : this.onTreepanelSelect,
				itemclick : this.onTreepanelItemClick
			}
		});
	},

	onPanelRender : function(abstractcomponent, options) {
		this.getMenuStore().load(function(records, op, success) { // #1
			// #2
			var menuPanel = Ext.ComponentQuery.query('mainmenu')[0];
			Ext.each(records, function(root) { // #3
				var menu = Ext.create('Packt.view.menu.Item', { // #4
					title : translations[root.get('text')], // #5
					iconCls : root.get('iconCls')
				// #6
				});
				Ext.each(root.items(), function(itens) { // #7
					Ext.each(itens.data.items, function(item) {
						menu.getRootNode().appendChild({ // #8
							text : translations[item.get('text')],
							leaf : true,
							iconCls : item.get('iconCls'),
							id : item.get('id'),
							className : item.get('className')
						});
					});
				});
				menuPanel.add(menu); // #9
			});
		});
	},
	

	onTreepanelSelect : function(selModel, record, index, options) {
		var mainPanel = this.getMainPanel(); // #1
		var newTab = mainPanel.items.findBy( // #2
		function(tab) {
			return tab.title === record.get('text'); // #3
		});
		if (!newTab) { // #4
			newTab = mainPanel.add({ // #5
				xtype : record.raw.className, // #6
				closable : true, // #7
				iconCls : record.get('iconCls'), // #8
				title : record.get('text')
			// #9
			});
		}
		mainPanel.setActiveTab(newTab); // #10
	},
	
	onTreepanelItemClick: function(view, record, item, index, event, options){
		this.onTreepanelSelect(view, record, index, options);
	}
});