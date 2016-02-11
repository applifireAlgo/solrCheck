Ext.define('Proejct4.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Proejct4.view.reportui.querycriteria.QueryCriteriaView',
			'Proejct4.view.reportui.datachart.DataChartViewTab',
			'Proejct4.view.reportui.datachart.DataChartViewPanel',
			'Proejct4.view.reportui.ReportViewController' ,
			'Proejct4.view.fw.MainDataPointPanel',
			'Proejct4.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
