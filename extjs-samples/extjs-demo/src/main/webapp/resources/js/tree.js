Ext.onReady(function(){
   //Ext.Msg.alert("Hi","Hello ExtJS");

	var nameLengthSorter = function(objectOne, objectTwo){
		var objectOneLength = objectOne.get('text').length,
		objectTwoLength= objectTwo.get('text').length;
		if(objectOneLength=== objectTwoLength){
		return 0;
		} else if(objectOneLength<objectTwoLength){
		return -1;
		} else {
		return 1;
		}
		};
		
	var store = Ext.create('Ext.data.TreeStore', {
		proxy: {
		type: 'ajax',
		url: 'resources/data/treeData.json'
		},
		root: {
		text: 'Countries',
		expanded: true
		}
		,sorters: [{
			sorterFn: nameLengthSorter,
			direction: 'ASC' //for descending change to 'DESC'
			},
			{
				property: 'text',
				direction: 'ASC' //for descending change to 'DESC'
			}
		]
		});
	
	Ext.create('Ext.tree.Panel', {
		title: 'Countries &amp; Cities',
		width: 500,
		height: 300,
		store: store,
		rootVisible: false,
		renderTo: Ext.getBody(),
		style: 'margin: 50px'
		});
	
	Ext.create('Ext.Button', {
		text: 'Sort Tree',
		renderTo: Ext.getBody(),
		handler: function() {
		//this will toggle ASC & DESC automatically for you.
		//store.sort('text');
		//or we can force a direction like so:
		store.sort('text', 'DESC');
		}
		});
	
	
	var storeForTreeA = Ext.create('Ext.data.TreeStore', {
		root: {
		expanded: true,
		children: [{
		text: "Item 1",
		leaf: true
		},{
		text: "Item 2",
		leaf: true
		},{
		text: "Item 3",
		leaf: true
		},{
			text: "Item 4",
			leaf: true
			}]
			}
			});
	
	var treeA = Ext.create('Ext.tree.Panel', {
		title: 'Tree One (drag from here)',
		store: storeForTreeA,
		width: 500,
		height: 200,
		viewConfig: {
		plugins: {
		ptype: 'treeviewdragdrop'
		}
		},
		renderTo: Ext.getBody(),
		style: 'margin: 50px'
		});
	
	var storeForTreeB = Ext.create('Ext.data.TreeStore', {
		root: {
		expanded: true,
		children: [{
		text: "Item 5",
		leaf: true
		}]
		}
		});
	
	var treeB = Ext.create('Ext.tree.Panel', {
		title: 'Tree Two (drop here)',
		width: 500,
		height: 200,
		store: storeForTreeB,
		viewConfig: {
		plugins: {
		ptype: 'treeviewdragdrop',
		enableDrop: true,
		enableDrag: false,
		allowContainerDrop: true
		}
		},
		renderTo: Ext.getBody(),
		style: 'margin: 50px'
		});
	
	
		
});