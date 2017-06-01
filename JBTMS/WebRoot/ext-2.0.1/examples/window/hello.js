Ext.onReady(function(){
    var win;
    var button = Ext.get('show-btn');

    button.on('click', function(){
        // create the window on the first click and reuse on subsequent clicks
        if(!win){
            win = new Ext.Window({
                el:'hello-win',
                title:'请选择数据',
                layout:'fit',
                width:500,
                height:345,
                closeAction:'hide',
                resizable:false,
                modal:true,
                plain: true,
                items: new Ext.Panel({
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