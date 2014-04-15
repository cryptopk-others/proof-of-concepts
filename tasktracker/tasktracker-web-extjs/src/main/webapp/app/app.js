Ext.application({
    requires: ['Ext.container.Viewport'],
    name: 'MyApp',
    appFolder: 'app',
    
    models: ['MyApp.model.User'],
    stores: ['MyApp.store.UserStore'],
    controllers: ['MyApp.controller.User'],
    views: ['MyApp.view.Users', 'MyApp.view.UsersGrid', 'MyApp.view.UserDetails','MyApp.view.CreateUser'],
    
    autoCreateViewport : true
    /*
    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: {
                xtype: 'userlist'
            }
        });
    }
    */
});