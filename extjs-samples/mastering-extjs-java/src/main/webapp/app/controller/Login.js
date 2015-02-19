Ext.define('Packt.controller.Login', { // #1
	extend : 'Ext.app.Controller', // #2
	requires: [
	'Packt.util.MD5',
	'Packt.util.Util',
	'Packt.util.SessionMonitor'
	],
	views : [ 'Login',
	          'Header',
	          'authentication.CapsLockTooltip',
	          'Packt.view.Translation'
	],
	refs: [
		{
		ref: 'capslockTooltip',
		selector: 'capslocktooltip'
		}
	],

	init : function(application) { // #4
		this.control({ // #5
			
			"login form button#submit": { // #1
				click: this.onButtonClickSubmit // #2
			},
			"login form button#cancel": { // #3
				click: this.onButtonClickCancel // #4
			},
			"login form textfield": {
				specialkey: this. onTextfieldSpecialKey
			},
			"login form textfield[name=password]": {
				keypress: this.onTextfieldKeyPress
			},
			"appheader button#logout": {
				click: this.onButtonClickLogout
			}
		});
	},
	
	onTextfieldKeyPress: function(field, e, options) {
		var charCode = e.getCharCode(); // #1
		if((e.shiftKey && charCode >= 97 && charCode <= 122) || // #2
				(!e.shiftKey && charCode >= 65 && charCode <= 90)){
			if(this.getCapslockTooltip() === undefined){ // #3
			Ext.widget('capslocktooltip'); // #4
			}
			this.getCapslockTooltip().show(); // #5
			} else {
			if(this.getCapslockTooltip() !== undefined){ // #6
			this.getCapslockTooltip().hide(); // #7
			}
			}
	},
				
				
	onTextfieldSpecialKey: function(field, e, options) {
		if (e.getKey() == e.ENTER){
		var submitBtn = field.up('form').down('button#submit');
		submitBtn.fireEvent('click', submitBtn, e, options);
		}
	},
		
	onButtonClickSubmit: function(button, e, options) {
		console.log('login submit'); // #5
		var formPanel = button.up('form'),
		login = button.up('login'),
		user = formPanel.down('textfield[name=user]').getValue(),
		pass = formPanel.down('textfield[name=password]').getValue();
		//pass = Packt.util.MD5.encode(pass);
		
		if (formPanel.getForm().isValid()) {
			Ext.get(login.getEl()).mask("Authenticating... Please wait...",'loading');
			Ext.Ajax.request({
				method: 'POST',
				url: 'rest/login',	
				//headers: {'Content-Type': 'application/json'},
				jsonData: {
					userName: user,
					password: pass
				},
				
				failure: function(conn, response, options, eOpts) {
					Ext.get(login.getEl()).unmask();
					var result = Packt.util.Util.decodeJSON(conn.responseText);
					Packt.util.Util.showErrorMsg(result.msg);
				},
				success: function(conn, response, options, eOpts) {
					Ext.get(login.getEl()).unmask();
					var result = Packt.util.Util.decodeJSON(conn.responseText);
					if (result.success == 'true') { // #3
						login.close(); // #4
						Ext.create('Packt.view.MyViewport'); // #5
						Packt.util.SessionMonitor.start();
					} else {
						Packt.util.Util.showErrorMsg(result.msg);
					}
				}
					
			
			}
			
			
			
			
			);
		}
	},
		
	onButtonClickCancel: function(button, e, options) {
		console.log('login cancel'); // #6
		button.up('form').getForm().reset();
	},
	
	onButtonClickLogout: function(button, e, options) {
		Ext.Ajax.request({
			url: 'rest/logout',
			headers: {'Content-Type':'application/json'},
			success: function(conn, response, options, eOpts){
				var result = Packt.util.Util.decodeJSON(conn.responseText);
				if (result.success == 'true') {
					button.up('mainviewport').destroy();
					window.location.reload();
				}
				else {
					Packt.util.Util.showErrorMsg(conn.responseText);
				}
			},
			failure: function(conn, response, options, eOpts) {
				Packt.util.Util.showErrorMsg(conn.responseText);
			}
		});
		}
});