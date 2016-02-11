Ext.define('Proejct4.view.databrowsercalendar.DBCalendar', {
	extend : 'Proejct4.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Proejct4.view.databrowsercalendar.DBCalendarController',
	             'Proejct4.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
