Ext.define('Packt.controller.staticData.AbstractController',
{
	extend : 'Ext.app.Controller',
	requires : [ 'Packt.util.Util' ],
	
	stores : [ 'staticData.Actors', 'staticData.Categories',
			'staticData.Cities', 'staticData.Countries',
			'staticData.Languages' ],
	
	views : [ 'staticData.AbstractGrid', 'staticData.Actors',
			'staticData.Categories', 'staticData.Cities',
			'staticData.Countries', 'staticData.Languages' ],
	
	init : function(application) {
		
		var countriesStore = Ext.getStore('countries');
		if(!countriesStore){
			Ext.create('Packt.store.staticData.Countries');
		}
		
		this.control({
			"staticdatagrid": {
				render: this.render,
				edit: this.onEdit
			 },
		
			 "staticdatagrid button#add": {
				 click: this.onButtonClickAdd
			  },
			  
			  "staticdatagrid actioncolumn": {
				  itemclick: this.handleActionColumn
			  },
			  
			  "staticdatagrid button#save": {
				  click: this.onButtonClickSave
			   },
			   
			   "staticdatagrid button#cancel": {
				   click: this.onButtonClickCancel
				},
				
				"staticdatagrid button#clearFilter": {
					click: this.onButtonClickClearFilter
				}
		
		
		});
		
		this.listen({
			store: {
				'#staticDataAbstract': {
					write: this.onStoreSync
				}
			}
		});
		
	},

	render: function(component, options) {
		component.getStore().load();
	},
	
	onButtonClickAdd: function (button, e, options) {
		var grid = button.up('staticdatagrid'), // #1
		store = grid.getStore(), // #2
		modelName = store.getProxy().getModel().modelName, // #3
		cellEditing = grid.getPlugin('cellplugin'); // #4
		store.insert(0, Ext.create(modelName, { // #5
		last_update: new Date() // #6
		}));
		cellEditing.startEditByPosition({row: 0, column: 1}); // #7
	},
	
	onEdit: function(editor, context, options) {
		//context.record.set('last_update', new Date());
	},
	
	handleActionColumn: function(column, action, view, rowIndex, colIndex, item, e) {
			var store = view.up('staticdatagrid').getStore(),
			rec = store.getAt(rowIndex);
			if (action == 'delete'){
				store.remove(rec);
				Ext.Msg.alert('Delete', 'Save the changes to persist the removed record.');
			}
	},
	
	onButtonClickSave: function (button, e, options) {
		button.up('staticdatagrid').getStore().sync();
	},
	
	onButtonClickCancel: function (button, e, options) {
		button.up('staticdatagrid').getStore().reload();
	},
	
	onButtonClickClearFilter: function (button, e, options) {
		button.up('staticdatagrid').filters.clearFilters();
	},
	
	onStoreSync: function(store, operation, options){
		Packt.util.Alert.msg('Success!', 'Your changes have been saved.');
	}
	
});