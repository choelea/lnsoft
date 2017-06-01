Ext.onReady(function(){
    var win;
    var button = Ext.get('showsjxx');
	button.on('click', function(){
        // create the window on the first click and reuse on subsequent clicks
        if(!win){
            win = new Ext.Window({
            	title:'任务信息',
                el:'dj-win',
                layout:'form',
                width:700,
                height:430,
                closeAction:'hide',
                modal:false,
                autoScroll:true,
                plain: true,
                resizable:false, 
                maximizable:true,
                hideBorders : true,
                items: new Ext.Panel({
                    el: 'dj-tabs',
                    autoTabs:true,
                    activeTab:0,
                    deferredRender:false,
                    border:false,
                    autoScroll:false
                })            
            });
        }
        win.show(this);
    });
    
});