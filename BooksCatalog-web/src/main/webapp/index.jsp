<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.github.kuper3.bookscatalog.util.Version"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BooksCatalog <%=Version.VALUE%></title>
</head>
<body>
<form action="greeting">
<label for="name">What is your name?</label>
<input type="text" name="name" id="name" />
<input type="submit" name="go" value="go"/>
</form>
<hr/>
${requestScope.greeting}

<p><a href="<c:url value='listBooksPage.jsf'/>">Books</a></p>
<p><a href="<c:url value='authorsListPage.jsf'/>">Authors</a></p>
</body>
</html>