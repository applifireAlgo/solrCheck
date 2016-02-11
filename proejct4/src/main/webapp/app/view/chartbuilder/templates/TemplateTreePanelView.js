Ext.define('Proejct4.view.chartbuilder.templates.TemplateTreePanelView', {
	extend : 'Ext.tree.Panel',
	requires:['Proejct4.view.chartbuilder.templates.TemplateTreePanelController'],
	controller:'templatecontroller',
	alias:'widget.templateview',
	itemId:'template-view',
	rootVisible : false,
	useArrows: true,
	//lines:true,
	listeners: {
		scope:'controller',
		itemcontextmenu:'itemContextMenuClick',
		load:'onTemplateTreeLoad'
	}	
});