/*
 * Ext JS Library 2.0.1
 * Copyright(c) 2006-2008, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */

Ext.onReady(function(){
    var win;
    var button = Ext.get('show-btn2');
    button.on('click', function(){
        // create the window on the first click and reuse on subsequent clicks
        if(!win){
            win = new Ext.Window({
            	title:"试题信息",
                el:'hello-win2',
                layout:'form',
                width:600,
                height:400,
                closeAction:'hide',
                modal:true,
                autoScroll:false,
                plain: true,
                resizable:false, 
                hideBorders : true,
                items: new Ext.Panel({
                    el: 'hello-tabs2',
                    autoTabs:true,
                    activeTab:0,
                    deferredRender:false,
                    border:false,
                    autoScroll:false
                }),
                buttons: [{
                    text: '确  定',
                    handler: function(){
                        win.hide();
                        setValue();
                    }
                }]
                
            });
        }
        win.show(this);
    });
});