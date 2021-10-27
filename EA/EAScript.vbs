option explicit

!INC Local Scripts.EAConstants-VBScript 
!INC Wrappers.Include
!INC Utils.TextFile 


'
' This code has been included from the default Project Browser template.
' If you wish to modify this template, it is located in the Config\Script Templates
' directory of your EA install path.   
'
' Script Name:
' Author:
' Purpose:
' Date:
'

'
' Project Browser Script main function
'
sub OnProjectBrowserScript()
	
	' Get the type of element selected in the Project Browser
	dim treeSelectedType
	treeSelectedType = Repository.GetTreeSelectedItemType() 
	Dim fso, objOutFile
	Set fso = CreateObject("Scripting.FileSystemObject")
	Set objOutFile = fso.CreateTextFile("C:\Users\alvar\IntelliJ Projects\src\com\example\jsonparser\file.json",True)
	
	' Handling Code: Uncomment any types you wish this script to support
	' NOTE: You can toggle comments on multiple lines that are currently
	' selected with [CTRL]+[SHIFT]+[C].
	select case treeSelectedType
	
		case otElement
'			' Code for when an element is selected
			'dim theElement as EA.Element
			'set theElement = Repository.GetTreeSelectedObject()
			'dim Attributes as EA.Collection 
			'dim anObject as EA.DiagramObject
			'set Attributes = theElement.Attributes 
			'dim attribute as EA.Attribute
			'for each anObject in Attributes  
				'set attribute = Repository.GetAttributeByID(anObject.InstanceID)
				'Msgbox "Attribute: " & attribute.Name 
			'next
			
		
		case otPackage
'			' Code for when a package is selected
			dim thePackage as EA.Package
			set thePackage = Repository.GetTreeSelectedObject() 
			Msgbox "Package " & thePackage.Name  
			  	
		case otDiagram 
			
			' Code for when a diagram is selected
			dim theDiagram as EA.Diagram
			set theDiagram = Repository.GetTreeSelectedObject()  
			'Msgbox "Diagram " & theDiagram.Name
			'Elements
			dim theElements as EA.Collection 
			set theElements = theDiagram.DiagramObjects
			dim anElement as EA.DiagramObject 
			dim TheElement as EA.Element  
			dim numOfElements 
			numOfElements = theElements.Count()
			'Msgbox CStr(numOfElements)
			'Attributes
			dim Attribute as EA.Attribute 
			dim Attributes as EA.Collection 
			dim anAttribute as EA.DiagramObject
			'Connectors 
			dim Connector as EA.Connector 
			dim Connectors as EA.Collection 
			dim aConnector as EA.Connector
			dim Connetor as EA.Connector 
			'Counters  
			dim countElements 
			dim countConnectors 
			dim countAttributes
			countElements = 0
			countConnectors = 0 
			countAttributes = 0
			objOutFile.WriteLine "{""Tables"" : ["
			for each anElement in theElements 
				set TheElement = Repository.GetElementByID(anElement.ElementID)   
				
				'Msgbox CStr(TheElement.GetBusinessRules()) 
				countElements = countElements + 1
				objOutFile.WriteLine "{""tableName"" : " & """" & TheElement.Name & """" & ", " 
				'dim theElementGUID as EA.Element.ElementGUID
				'set theElementGUID = theElement.ElementGUID  
				'objOutFile.WriteLine theElement.Name & theElement.ElementGUID
				
				'Call Repository.GetProjectInterface().GenerateElementDDL("{2376E29D-A1D7-4ce3-9B79-C5FE88755E07}", "C:\Users\alvar\Downloads\Classes.sql","recurse=1")
				'Call Repository.GetProjectInterface().GUIDtoXML("{2376E29D-A1D7-4ce3-9B79-C5FE88755E07}")
				set Connectors = TheElement.Connectors 
				set Attributes = TheElement.Attributes 
				dim numOfConnectors 
				numOfConnectors = Connectors.Count 
				'Msgbox numOfConnectors 
				dim numOfAttributes
				numOfAttributes = Attributes.Count 
				'Msgbox numOfAttributes  
				objOutFile.WriteLine """connectors"" : ["  
				
				for each aConnector in Connectors  
					'Msgbox "Siin "
					'objOutFile.WriteLine aConnector.ClientEnd  
					'set Connector = Repository.GetConnectorByID(aConnector.ConnectorID) 
					'Connector.Constraints '
					
					
					'Msgbox CStr(aConnector.CustomProperties.GetAt(0))
					'Msgbox CStr(aConnector.StyleEx) 
					countConnectors = countConnectors + 1
					objOutFile.WriteLine "{""source"": " & """" & Repository.GetElementByID(aConnector.ClientID).Name & """" & ", ""end"": " & """" &_
					Repository.GetElementByID(aConnector.SupplierID).Name & """" & ", ""sourceCardinality"": " & """" & CStr(aConnector.ClientEnd.Cardinality) & """"  &_
					", ""endCardinality"": " & """" & CStr(aConnector.SupplierEnd.Cardinality) & """" 
					
					if  countConnectors < numOfConnectors then
						objOutFile.WriteLine "}, " 
					else 
						objOutFile.WriteLine "}"
					end if	
					
					
				next 
				objOutFile.WriteLine "], " 
				countConnectors = 0
				
				objOutFile.WriteLine """attributes"" : ["
				for each anAttribute in Attributes 
					
					set Attribute = Repository.GetAttributeByID(anAttribute.AttributeID)  
					'Msgbox Len(CStr(Attribute.Default))
					countAttributes = countAttributes + 1
					objOutFile.WriteLine "{""name"":" & """" & Attribute.Name & """" & ", ""type"": " & """" & Attribute.Type & """"  &_
					", ""length"": " & Attribute.Length & ", ""notNull"": " & LCase(Attribute.AllowDuplicates) & ", ""pKey"": " & LCase(Attribute.IsOrdered) & ", ""fKey"": " & LCase(Attribute.IsCollection) &_ 
					", ""initialValue"":" & """" &Attribute.Default & """" 
					if  countAttributes < numOfAttributes then
						objOutFile.WriteLine "}, " 
					else 
						objOutFile.WriteLine "}"
					end if	
					'objOutFile.WriteLine Attribute.Name  
					'objOutFile.WriteLine Attribute.Notes 
					'objOutFile.WriteLine Attribute.Type 
					'objOutFile.WriteLine Attribute.Length 
					'objOutFile.WriteLine Attribute.IsOrdered
					'Msgbox "Attribute " & Attribute.Name 
					'set Constraints = Attribute.
					'Msgbox "Siin " & CStr(Constraints.Count)
					'for each aConstraint in Constraints 
						'Msgbox "Hey"
						'Msgbox "Constraint " & aConstraint.Notes
						'objOutFile.WriteLine aConstraint.Notes				
					'next									
				next 
				objOutFile.WriteLine "]" 
				countAttributes = 0
				
				
				if  countElements < numOfElements then
						objOutFile.WriteLine "}, " 
					else 
						objOutFile.WriteLine "}"
					end if	
			next 
			objOutFile.WriteLine "]"
			objOutFile.WriteLine "}"
			objOutFile.close 
'			
'		case otAttribute
'			' Code for when an attribute is selected
'			dim theAttribute as EA.Attribute
'			set theAttribute = Repository.GetTreeSelectedObject()
'			
'		case otMethod
'			' Code for when a method is selected
'			dim theMethod as EA.Method
'			set theMethod = Repository.GetTreeSelectedObject()
		
		case else
			' Error message
			Session.Prompt "This script does not support items of this type.", promptOK
			
	end select
	
end sub

OnProjectBrowserScript
