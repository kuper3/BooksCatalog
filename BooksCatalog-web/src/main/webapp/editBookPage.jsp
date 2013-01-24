<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit book</title>
</head>
<body>
	<f:view>

		<h:form id="book">
			<center>

				<h:panelGrid>
					<h:outputLabel value="ISBN: " style="font-weight:bold" />
					<h:inputText id="isbn" value="#{bookListController.selectedBook.isbn}" required="true">
					    <f:validateLength minimum="13" maximum="13"/>
					    <rich:ajaxValidator event="onblur"/>
					</h:inputText>
					<rich:message for="isbn" showDetail="false" showSummary="true" style="color: red;"/>

					<h:outputLabel value="Name: " style="font-weight:bold" />
					<h:inputText id="name" value="#{bookListController.selectedBook.name}" required="true">
					  <f:validateLength minimum="3" />
					  <rich:ajaxValidator event="onblur"/>
					</h:inputText>
					<rich:message for="name" showDetail="false" showSummary="true" style="color: red;" />

					<h:outputLabel value="Publisher: " style="font-weight:bold" />
					<h:inputText id="publisher" value="#{bookListController.selectedBook.publisher}" />

					<h:outputLabel value="Year Published: " style="font-weight:bold" />
					<h:inputText id="year" value="#{bookListController.selectedBook.yearPublished}">
						<f:converter converterId="javax.faces.Integer"/>
						<rich:ajaxValidator event="onclick" />
						<rich:ajaxValidator event="onblur"/>
					</h:inputText>
					<rich:message for="year" showDetail="false" showSummary="true" style="color: red;"/>

					<h:commandButton value="Save" action="#{bookListController.onSave}" />
					<h:commandButton value="Delete"
						action="#{bookListController.onDelete}" />
					<h:commandButton value="Cancel"
						action="#{bookListController.onCancel}" />
					<br>					

				</h:panelGrid>
			</center>
		</h:form>

	</f:view>
</body>
</html>