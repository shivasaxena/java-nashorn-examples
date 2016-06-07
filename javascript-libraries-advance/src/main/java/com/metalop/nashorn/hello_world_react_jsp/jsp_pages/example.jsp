<%@page import="java.util.ArrayList"%>

<html>
<head>
<title>Java Code Geeks Snippets - Sample JSP Page</title>
<meta>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</meta>
</head>

<body>
	<c:out value="Jetty JSP Example"></c:out>
	<br /> 
	Current date is: <%=new java.util.Date()%>
</body>
</html>