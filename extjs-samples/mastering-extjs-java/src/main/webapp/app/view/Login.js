Ext.define('Packt.view.Login', { // #1
	extend : 'Ext.window.Window', // #2
	alias : 'widget.login', // #3
	
	requires: [
	           'Packt.view.Translation'
	       ],
	       
	autoShow : true, // #4
	height : 200, // #5
	width : 360, // #6
	layout : {
		type : 'fit' // #7
	},
	iconCls : 'key', // #8
	title : translations.login, // #9
	closeAction : 'hide', // #10
	closable : false, // #11
	
	items: [
	        {
		xtype : 'form', // #12
		frame : false, // #13
		bodyPadding : 15, // #14
		defaults : { // #15
			xtype : 'textfield', // #16
			anchor : '100%', // #17
			labelWidth : 60,
			allowBlank: false, // #20
			vtype: 'alphanum', // #21
			minLength: 3, // #22
			msgTarget: 'under' // #23
		// #18
		},
		items : [ {
			name : 'user',
			fieldLabel: translations.user,
			maxLength: 25,
			value: 'admin'
		}, {
			inputType : 'password', // #19
			name : 'password',
			fieldLabel: translations.password,
			maxLength: 15,
			enableKeyEvents: true,
			id: 'password',
			value: 'admin'
			//,vtype: 'customPass'
		} ],
		
		dockedItems: [
		              {
			xtype : 'toolbar',
			dock : 'bottom',
			items : [
				{
					xtype: 'translation'
				},      
			    {
				xtype : 'tbfill' // #24
			    }, 
			   {
				xtype : 'button', // #25
				itemId : 'cancel',
				iconCls : 'cancel',
				text: translations.cancel
			}, {
				xtype : 'button', // #26
				itemId : 'submit',
				formBind : true, // #27
				iconCls : 'key-go',
				text: translations.submit
			} ]
		} ]
	} ]
	
	
	
});