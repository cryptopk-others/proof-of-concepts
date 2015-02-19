Ext.define('Packt.controller.security.Users', {
	extend : 'Ext.app.Controller',
	requires: [ 'Packt.util.Util','Packt.util.Alert' ],
	views : [ 'security.Users', 'security.Profile'],
	stores: [ 'security.Groups' ],

	     refs: [
	         {
	             ref: 'usersList',
	             selector: 'userslist'
	         },
	         {
	             ref: 'userPicture',
	             selector: 'profile image'
	         }
	     ],
	init : function(application) {
		var groupsStore = Ext.getStore('groupStore');
		//console.log('Getting groupsStore from registry: '+groupsStore);
		if(!groupsStore){
			Ext.create('Packt.store.security.Groups');
			//console.log('Created groupsStore');
		}
		
		this.control({
			"userslist" : { // #2
				render : this.onRender
			},
			"users button#add": {
				click: this.onButtonClickAdd
			},
			"users button#edit": {
				click: this.onButtonClickEdit
			},
			"profile button#save": {
				click: this.onButtonClickSave
			},
			"profile button#cancel": {
				click: this.onButtonClickCancel
			},
			"profile filefield": {
				change: this.onFilefieldChange
			},
			"users button#delete": {
				click: this.onButtonClickDelete
			}
		});
	},
	onRender : function(component, options) { // #3
		
		component.getStore().load(); // #4
	},
	
	onButtonClickAdd: function (button, e, options) {
		var win = Ext.create('Packt.view.security.Profile');
		win.setTitle('Add new User');
		win.show();
	},
	
	onButtonClickEdit: function (button, e, options) {
		var grid = this.getUsersList(), // #1
		record = grid.getSelectionModel().getSelection();
		if(record[0]){ // #2
		var editWindow = Ext.create('Packt.view.security.Profile');
		editWindow.down('form').loadRecord(record[0]); // #3
		if (record[0].get('picture')) { //#4
		var img = editWindow.down('image');
		img.setSrc('resources/profileImages/' + record[0].get('picture'));
		}
		editWindow.setTitle(record[0].get('name')); // #5
		editWindow.show();
		}
	},
	
	onButtonClickSave: function(button, e, options) {
		var win = button.up('window'), // #1
		formPanel = win.down('form'), // #2
		store = this.getUsersList().getStore();// #3
		if (formPanel.getForm().isValid()) { // #4
		formPanel.getForm().submit({// #5
		clientValidation: true,
		enctype: 'multipart/form-data',
		url: 'rest/security/saveUser', // #6
		//success and failure
		success: function(form, action) {
			var result = action.result; // #7
			if (result.success) {
				Packt.util.Alert.msg('Success!', 'User saved.'); // #8
				store.load();
				win.close();
			} else {
				Packt.util.Util.showErrorMsg(result.msg); // #9
			}
			},
			failure: function(form, action) {
				switch (action.failureType) {
				case Ext.form.action.Action.CLIENT_INVALID:
					Ext.Msg.alert('Failure', 'Form fields may not be submitted with invalid values');
					break;
				case Ext.form.action.Action.CONNECT_FAILURE:
					Ext.Msg.alert('Failure', 'Ajax communication failed');
					break;
				case Ext.form.action.Action.SERVER_INVALID:
					Ext.Msg.alert('Failure', action.result.msg);
				}
			}
		});
		}
	},
	
	onButtonClickCancel: function(button, e, options) {
		button.up('window').close();
	},
	
	onFilefieldChange: function(filefield, value, options) {
		var file = filefield.fileInputEl.dom.files[0]; // #1
		var picture = this.getUserPicture(); // #2
		if (typeof FileReader !== "undefined" && (/image/i).test(file.type)) { // #3
		var reader = new FileReader(); // #4
		reader.onload = function(e){ // #5
		picture.setSrc(e.target.result); // #6
		};
		reader.readAsDataURL(file); // #7
		} else if (!(/image/i).test(file.type)){ // #8
		Ext.Msg.alert('Warning', 'You can only upload image files!');
		filefield.reset(); // #9
		}
	},
	
	onButtonClickDelete: function (button, e, options) {
		var grid = this.getUsersList(),
		record = grid.getSelectionModel().getSelection(),
		store = grid.getStore();
		if (store.getCount() >= 2 && record[0]){
		// delete logic here
			
			Ext.Msg.show({
				title:'Delete?',
				msg: 'Are you sure you want to delete?',
				buttons: Ext.Msg.YESNO,
				icon: Ext.Msg.QUESTION,
				fn: function (buttonId){
				if (buttonId == 'yes'){
				Ext.Ajax.request({
				url: 'rest/security/deleteUser',
				params: {
				id: record[0].get('id')
				},
				// success and failure
				success: function(conn, response, options, eOpts) {
					var result = Packt.util.Util.decodeJSON(conn.responseText);
					if (result.success) {
					Packt.util.Alert.msg('Success!', 'User deleted.');
					store.load();
					} else {
					Packt.util.Util.showErrorMsg(conn.responseText);
					}
				},
				failure: function(conn, response, options, eOpts) {
					Packt.util.Util.showErrorMsg(conn.responseText);
				}
				});
				}
				}
				});
			
			
		} else if (store.getCount() == 1) {
		Ext.Msg.show({
		title:'Warning',
		msg: 'You cannot delete all the users from the application.',
		buttons: Ext.Msg.OK,
		icon: Ext.Msg.WARNING
		});
		}
	}
});