<%@page import="java.util.ArrayList"%>
<%@page import="javax.script.ScriptEngine"%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page import="javax.script.Invocable"%>
<%@page import="com.metalop.nashorn.utilities.Utilities"%>

<html>
<head>
<title>Sample JSP page using React.js to render contents on server</title>
<meta>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>

<body>
	<br /> 
	<%
	ScriptEngine nashorn =  new ScriptEngineManager().getEngineByName("nashorn");
    try {
		nashorn.eval(Utilities.readFromResourcesAsInputStream("React(with addons)v15.1.0.js"));
		nashorn.eval(Utilities.readFromResourcesAsInputStream("ReactDOMServerV5.1.0.js"));
		nashorn.eval(Utilities.readFromResourcesAsInputStream("HelloWorldReactApp.js"));
		Invocable invocable = (Invocable) nashorn;
		String s = (String) invocable.invokeFunction("getHelloWorldMarkup");
		String outputHtml = (String) nashorn.eval("ReactDOMServer.renderToString(React.createElement(ReactPageComponent));");
		response.getWriter().println(s);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException(e);
	}
	%>
	<c:out value=outputHtml></c:out>
</body>
</html>