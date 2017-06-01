Ext.onReady(function(){
    var win;
    var button = Ext.get('show-btn');
    button.on('click', function(){
        // create the window on the first click and reuse on subsequent clicks
        if(!win){
            win = new Ext.Window({
                el:'hello-win',
                layout:'fit',
                width:500,
                height:300,
                closeAction:'hide',
                resizable:false,
                modal:true,
                plain: true,
                items: new Ext.TabPanel({
                    el: 'hello-tabs',
                    autoTabs:true,
                    activeTab:0,
                    deferredRender:false,
                    border:false,
                    autoScroll:false
                }),
                buttons: [{
                    text: '确  定',
                    handler: function(){                        
                        setValue();
                        win.hide();
                    }
                }]
                
            });
        }
        win.show(this);
    });
});