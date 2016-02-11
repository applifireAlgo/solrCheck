Ext.define('Proejct4.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Proejct4.view.reportui.datachart.DataChartTController',
	             'Proejct4.view.reportui.datachart.datagrid.DataGridView',
	             'Proejct4.view.reportui.datachart.chart.ChartTabView',
	             'Proejct4.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});