Ext.define('Proejct4.view.resource.ResourcePanel', {
	extend : 'Ext.panel.Panel',
	xtype : 'resourcePanel',
	itemId : 'resourcePanel',
	requires : ['Proejct4.view.resource.ResourcePanelController'],
	controller : 'resourcePanelController',
	cls:'resourcePanelStyle',
	title:'<p style="color:#fff;font-weight:bold;font-size:20px;margin:0px;padding:0%;"><img src="resources/css/images/logo.png" width="60" height="60" align="center" hspace="5" style="border-radius:60%;">proejct4</p>',
    resizable:false,
    overflowY:'auto',
	listeners:{
		scope:'controller',
		afterrender:'onResourcePanelAfterRender'
	},
	plugins:'responsive',
	responsiveConfig: {
        'width < 768 && tall': {
            visible: false,
            width:'25%'
        },
        'width >= 768': {
            visible: true,
            width:'16%'
        }
    }
});
