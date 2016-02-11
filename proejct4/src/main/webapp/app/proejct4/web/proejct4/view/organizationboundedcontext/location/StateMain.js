Ext.define('Proejct4.proejct4.web.proejct4.view.organizationboundedcontext.location.StateMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "StateMainController",
     "restURL": "/State",
     "defaults": {
          "split": true
     },
     "requires": ["Proejct4.proejct4.shared.proejct4.model.organizationboundedcontext.location.StateModel", "Proejct4.proejct4.web.proejct4.controller.organizationboundedcontext.location.StateMainController", "Proejct4.proejct4.shared.proejct4.model.organizationboundedcontext.location.CountryModel", "Proejct4.proejct4.shared.proejct4.viewmodel.organizationboundedcontext.location.StateViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "State",
               "name": "StateTreeContainer",
               "itemId": "StateTreeContainer",
               "restURL": "/State",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "StateTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code",
                         "fieldId": "67603070-C17B-4076-B9FC-EAD99EB25ED2",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Proejct4.proejct4.shared.proejct4.model.organizationboundedcontext.location.CountryModel"
                         },
                         "bindable": "countryId"
                    }, {
                         "name": "stateName",
                         "itemId": "stateName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Name",
                         "fieldId": "2696C14F-63FA-4E3D-9664-AFF06DE9C8B0",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "stateName"
                    }, {
                         "name": "stateCode",
                         "itemId": "stateCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "State Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code",
                         "fieldId": "3A856815-3376-4EC8-921D-564ECD508B3C",
                         "minValue": "0",
                         "maxValue": "2",
                         "bindable": "stateCode"
                    }, {
                         "name": "stateCodeChar2",
                         "itemId": "stateCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 2",
                         "fieldId": "2C527716-5852-4F48-BC2F-B705740A9F08",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar2"
                    }, {
                         "name": "stateCodeChar3",
                         "itemId": "stateCodeChar3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 3",
                         "fieldId": "A3B2FEBE-C76F-4CE3-8AAE-67E55076AB67",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar3"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "StateViewModel",
                    "xtype": "form",
                    "displayName": "State",
                    "title": "State",
                    "name": "State",
                    "itemId": "State",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Id<font color='red'> *<\/font>",
                         "fieldId": "29E50BF4-0ED8-4966-8CBE-7ABD99520645",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "stateId",
                         "bind": "{stateId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "67603070-C17B-4076-B9FC-EAD99EB25ED2",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Proejct4.proejct4.shared.proejct4.model.organizationboundedcontext.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateName",
                         "itemId": "stateName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2696C14F-63FA-4E3D-9664-AFF06DE9C8B0",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "stateName",
                         "bind": "{stateName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCode",
                         "itemId": "stateCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "State Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code",
                         "fieldId": "3A856815-3376-4EC8-921D-564ECD508B3C",
                         "minValue": "0",
                         "maxValue": "2",
                         "bindable": "stateCode",
                         "bind": "{stateCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCodeChar2",
                         "itemId": "stateCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 2<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2C527716-5852-4F48-BC2F-B705740A9F08",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar2",
                         "bind": "{stateCodeChar2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCodeChar3",
                         "itemId": "stateCodeChar3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "State Code 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Code 3",
                         "fieldId": "A3B2FEBE-C76F-4CE3-8AAE-67E55076AB67",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "stateCodeChar3",
                         "bind": "{stateCodeChar3}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateDescription",
                         "itemId": "stateDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "State Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State Description",
                         "fieldId": "E6EE8294-6D73-43BA-B5C6-FBE684F4885F",
                         "bindable": "stateDescription",
                         "bind": "{stateDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateFlag",
                         "itemId": "stateFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "7EFFEC74-8C7E-4F2D-927C-2FE3002F8271",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "stateFlag",
                         "bind": "{stateFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapital",
                         "itemId": "stateCapital",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Capital",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital",
                         "fieldId": "1E80B4B3-55AF-4BD6-97D0-EDDD3A11C91E",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "stateCapital",
                         "bind": "{stateCapital}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapitalLatitude",
                         "itemId": "stateCapitalLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capitial Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capitial Latitude",
                         "fieldId": "AFDEB988-8005-4BD8-AE25-51DFA7720E13",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "stateCapitalLatitude",
                         "bind": "{stateCapitalLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "stateCapitalLongitude",
                         "itemId": "stateCapitalLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capitial Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capitial Longitude",
                         "fieldId": "99BE7553-6517-4EC9-B826-092D1582A52D",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "stateCapitalLongitude",
                         "bind": "{stateCapitalLongitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "122DE7E6-C22E-46DE-8437-3CE77F9C72BE",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 498,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 498,
                              "customId": 530
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 498,
                              "customId": 531,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 498,
                              "customId": 532,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "State",
                    "title": "Details Grid",
                    "name": "StateGrid",
                    "itemId": "StateGrid",
                    "restURL": "/State",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "State Id",
                         "dataIndex": "stateId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Country Code",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State Name",
                         "dataIndex": "stateName",
                         "flex": 1
                    }, {
                         "header": "State Code",
                         "dataIndex": "stateCode",
                         "flex": 1
                    }, {
                         "header": "State Code 2",
                         "dataIndex": "stateCodeChar2",
                         "flex": 1
                    }, {
                         "header": "State Code 3",
                         "dataIndex": "stateCodeChar3",
                         "flex": 1
                    }, {
                         "header": "State Description",
                         "dataIndex": "stateDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "stateFlag",
                         "flex": 1
                    }, {
                         "header": "Capital",
                         "dataIndex": "stateCapital",
                         "flex": 1
                    }, {
                         "header": "Capitial Latitude",
                         "dataIndex": "stateCapitalLatitude",
                         "flex": 1
                    }, {
                         "header": "Capitial Longitude",
                         "dataIndex": "stateCapitalLongitude",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "StateViewModel",
               "xtype": "form",
               "displayName": "State",
               "title": "State",
               "name": "State",
               "itemId": "State",
               "bodyPadding": 10,
               "items": [{
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Id<font color='red'> *<\/font>",
                    "fieldId": "29E50BF4-0ED8-4966-8CBE-7ABD99520645",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "stateId",
                    "bind": "{stateId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "67603070-C17B-4076-B9FC-EAD99EB25ED2",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Proejct4.proejct4.shared.proejct4.model.organizationboundedcontext.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateName",
                    "itemId": "stateName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2696C14F-63FA-4E3D-9664-AFF06DE9C8B0",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "stateName",
                    "bind": "{stateName}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCode",
                    "itemId": "stateCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "State Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code",
                    "fieldId": "3A856815-3376-4EC8-921D-564ECD508B3C",
                    "minValue": "0",
                    "maxValue": "2",
                    "bindable": "stateCode",
                    "bind": "{stateCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCodeChar2",
                    "itemId": "stateCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code 2<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2C527716-5852-4F48-BC2F-B705740A9F08",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "stateCodeChar2",
                    "bind": "{stateCodeChar2}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCodeChar3",
                    "itemId": "stateCodeChar3",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "State Code 3",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Code 3",
                    "fieldId": "A3B2FEBE-C76F-4CE3-8AAE-67E55076AB67",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "stateCodeChar3",
                    "bind": "{stateCodeChar3}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateDescription",
                    "itemId": "stateDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "State Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State Description",
                    "fieldId": "E6EE8294-6D73-43BA-B5C6-FBE684F4885F",
                    "bindable": "stateDescription",
                    "bind": "{stateDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateFlag",
                    "itemId": "stateFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "7EFFEC74-8C7E-4F2D-927C-2FE3002F8271",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "stateFlag",
                    "bind": "{stateFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapital",
                    "itemId": "stateCapital",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Capital",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital",
                    "fieldId": "1E80B4B3-55AF-4BD6-97D0-EDDD3A11C91E",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "stateCapital",
                    "bind": "{stateCapital}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapitalLatitude",
                    "itemId": "stateCapitalLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capitial Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capitial Latitude",
                    "fieldId": "AFDEB988-8005-4BD8-AE25-51DFA7720E13",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "stateCapitalLatitude",
                    "bind": "{stateCapitalLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "stateCapitalLongitude",
                    "itemId": "stateCapitalLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capitial Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capitial Longitude",
                    "fieldId": "99BE7553-6517-4EC9-B826-092D1582A52D",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "stateCapitalLongitude",
                    "bind": "{stateCapitalLongitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "122DE7E6-C22E-46DE-8437-3CE77F9C72BE",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 498,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 498,
                         "customId": 530
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 498,
                         "customId": 531,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 498,
                         "customId": 532,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});