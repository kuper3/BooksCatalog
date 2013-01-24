<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="a4j"uri="http://richfaces.org/a4j" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of book</title>
</head>
<body>

	<f:view>
        <h:form id="mainForm">
        
        
		<h:dataTable id="dataTable" value="#{bookListController.books}" var="item" binding="#{bookListController.dataTable}" 
		   
			bgcolor="#F1F1F1" border="10" cellpadding="5" cellspacing="3"
			first="0" rows="4" width="50%" dir="LTR" frame="hsides" rules="all"
			summary="This is a JSF code to create dataTable.">

				<f:facet name="header">
				<h:outputText value="This is 'dataTable' demo" />
			</f:facet>

			<h:column>
				<f:facet name="header">
					<h:outputText value="isbn" />
				</f:facet>
				<h:outputText value="#{item.isbn}"/>
			</h:column>

			<h:column>
				<f:facet name="header">
					<h:outputText value="name" />
				</f:facet>
				<h:outputText value="#{item.name}"></h:outputText>
			</h:column>

			<h:column>				      
				<h:commandLink  value="Detail..." action="#{bookListController.showDetail}" />				
			</h:column>			

			<f:facet name="footer"/>

		</h:dataTable>
		<br>

			<a4j:commandButton value="Ajax Add new" reRender="dataTable"
				onclick="Richfaces.showModalPanel('modalPanel');">
			</a4j:commandButton>
			<br>		
			
</h:form>			

			<rich:modalPanel id="modalPanel" autosized="true">
				<h:form id="panelForm">			
				    
					<a onclick="Richfaces.hideModalPanel('modalPanel');" href="#">Hide Panel </a> <br>

					<h:panelGrid>
						<h:outputLabel value="ISBN: " style="font-weight:bold" />
						<h:inputText id="isbn" value="#{bookListController.selectedBook.isbn}" />
						<h:message for="isbn" showDetail="false" showSummary="true" />

						<h:outputLabel value="Name: " style="font-weight:bold" />
						<h:inputText id="name" value="#{bookListController.selectedBook.name}" />
						<h:message for="name" showDetail="false" showSummary="true" />

						<h:outputLabel value="Publisher: " style="font-weight:bold" />
						<h:inputText value="#{bookListController.selectedBook.publisher}" />
						<h:message for="name" showDetail="false" showSummary="true" />

						<h:outputLabel value="Year Published: " style="font-weight:bold" />
						<h:inputText value="#{bookListController.selectedBook.yearPublished}">
							<f:converter converterId="javax.faces.Integer" />
						</h:inputText>
						<h:message for="name" showDetail="false" showSummary="true" />

						<h:commandButton value="Add" action="#{bookListController.addNewBook}"/>
						<br>
						<h:commandButton value="Cancel" />

					</h:panelGrid>
				</h:form>
			</rich:modalPanel>

		

	</f:view>
</body>
</html>