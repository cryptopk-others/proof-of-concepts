/*Ext.onReady(function(){
	Ext.Msg.alert('Hi','Hello');
});
 */
/*
 Ext.application({
 name: 'MyApp',

 extend: 'MyApp.Application',

 autoCreateViewport: true
 });
 */

Ext.Loader.setConfig({
    enabled: true,
    paths: {
        //Ext: '.',
        'Ext.ux': 'resources/extjs/ux'
        //'Packt.util': 'app/util'
    }
});

Ext.application({ // #1
	name : 'Packt', // #2
	splashscreen: {},
	//enableQuickTips: true,
	controllers: [
	      'Login',
	      'TranslationManager',
	      'Menu',
	      'security.Users',
	      'staticData.AbstractController'
	],

	init : function() {
		splashscreen = Ext.getBody().mask('Loading application', 'splashscreen');
		splashscreen.addCls('splashscreen');
		Ext.DomHelper.insertFirst(Ext.query('.x-mask-msg')[0], {
			cls: 'x-splash-icon'
		});
		
	},

	launch : function() { // #3
		Ext.tip.QuickTipManager.init();
		console.log('launch'); // #4
		
		Ext.apply(Ext.form.field.VTypes, {
		    //  vtype validation function
		    customPass: function(val, field) {
		        return /^((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})/.test(val);
		    },
		    // vtype Text property: The error text to display when the validation function returns false
		    customPassText: 'Not a valid password.  Length must be at least 6 characters and maximum of 20Password must contain one digit, one letter lowercase, one letter uppercase, onse special symbol @#$% and between 6 and 20 characters.',
		});
		
		var task = new Ext.util.DelayedTask(function() {
			//Fade out the body mask
            splashscreen.fadeOut({
                duration: 1000,
                remove:true
            });

            //Fade out the icon and message
			splashscreen.next().fadeOut({
			duration: 1000,
			remove:true,
			listeners: {
				afteranimate: function(el, startTime, eOpts ){
				Ext.widget('login'); // #1
				}
				}
			});
			console.log('launch'); // #1
			});
			task.delay(2000);
			
	}
});