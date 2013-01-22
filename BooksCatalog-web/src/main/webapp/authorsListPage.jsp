<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich" %>
 
<f:view>
    <html>
    <head>
        <title>Hello World JSF Example</title>
    </head>
    <body>
    <h:form>
        <p>This is a simple hello world page using Faces.</p>
        <p>Enter your message here: <br/></p>
        <h:outputText value="#{authors.list}" />
        <h:commandButton value="Submit" action="submit"/>
        <p> <rich:calendar /> </p>
    </h:form>  
    </body>
    </html>
</f:view>