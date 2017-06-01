Ext.onReady(function(){
    var wingrzl;
    var buttongrzl = Ext.get('showgrzl');
    buttongrzl.on('click', function(){
    	 sfcg.innerHTML="";
        // create the window on the first click and reuse on subsequent clicks
        if(!wingrzl){
            wingrzl = new Ext.Window({
            	title:'个人资料',
                el:'hello-wgrzl',
                layout:'form',
                width:450,
                draggable:false,
                height:384,
                closeAction:'hide',
                modal:true,
                plain: true,
                resizable:false,
                hideBorders : true,
                items: new Ext.Panel({
                    el: 'hello-tgrzl',
                    autoTabs:true,
                    activeTab:0,
                    deferredRender:false,
                    border:false,
                    autoScroll:true
                })
                        
            });
        }
        wingrzl.show(this);
    });
});

Ext.onReady(function(){
    var ggwin;
    var ggbutton = Ext.get('showggxx');
    ggbutton.on('click', function(){
        // create the window on the first click and reuse on subsequent clicks
        if(!ggwin){
            ggwin = new Ext.Window({
            	title:'公告信息',
                el:'gg-win',
                layout:'form',
                width:500,
                height:315,
                closeAction:'hide',
                resizable:false,
                modal:true,
                plain: true,
                hideBorders : true,
                items: new Ext.Panel({
                    el: 'gg-tabs',
                    autoTabs:true,
                    activeTab:0,
                    deferredRender:false,
                    border:false,
                    autoScroll:true
                })            
            });
        }
        ggwin.show(this);
    });
});
