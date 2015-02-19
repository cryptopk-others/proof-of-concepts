Ext.define('Packt.view.security.Profile', {
	extend : 'Ext.window.Window',
	alias : 'widget.profile',
	height : 260,
	width : 550,
	requires : [ 'Packt.util.Util' ],
	layout : {
		type : 'fit'
	},
	title : 'User',
	items : [ {
		xtype : 'form',
		bodyPadding : 5,
		layout : {
			type : 'hbox', // #1
			align : 'stretch'
		},
		items : [ {
			xtype : 'fieldset',
			flex : 2,
			title : 'User Information',
			defaults : {
				afterLabelTextTpl : Packt.util.Util.required, // #1
				anchor : '100%',
				xtype : 'textfield',
				allowBlank : false,
				labelWidth : 60
			},
			items : [ {
				xtype : 'hiddenfield',
				fieldLabel : 'Label',
				name : 'id',
				value: 0
			}, {
				fieldLabel : 'Username',
				name : 'userName'
			}, {
				fieldLabel : 'Name',
				maxLength : 100,
				name : 'name'
			}, {
				fieldLabel : 'Email',
				maxLength : 100,
				name : 'email'
			}, {
				xtype : 'combobox',
				fieldLabel : 'Group',
				name : 'groupId', // #1
				displayField : 'name', // #2
				valueField : 'id', // #3
				queryMode : 'local', // #4
				store : 'security.Groups' // #5
			}
			
			, {
				xtype : 'filefield',
				fieldLabel : 'Picture',
				name : 'pictureImage',
				allowBlank : true, // #6
				afterLabelTextTpl : '' // #7
			} ]
		}, {
			xtype : 'fieldset',
			title : 'Picture',
			width : 170, // #1
			items : [ {
				xtype : 'image', // #2
				height : 150,
				width : 150,
				src : '' // #3
			} ]
		} ],
		dockedItems : [ {
			xtype : 'toolbar',
			flex : 1,
			dock : 'bottom',
			ui : 'footer',
			layout : {
				pack : 'end', // #1
				type : 'hbox'
			},
			items : [ {
				xtype : 'button',
				text : 'Cancel',
				itemId : 'cancel',
				iconCls : 'cancel'
			}, {
				xtype : 'button',
				text : 'Save',
				itemId : 'save',
				iconCls : 'save'
			} ]
		} ]
	}

	]
});