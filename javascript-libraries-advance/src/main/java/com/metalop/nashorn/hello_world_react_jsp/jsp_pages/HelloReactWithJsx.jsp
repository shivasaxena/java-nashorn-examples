<%@page import="java.util.ArrayList"%>
<%@page import="javax.script.ScriptEngine"%>
<%@page import="javax.script.ScriptEngineManager"%>
<%@page import="javax.script.Invocable"%>
<%@page import="javax.script.SimpleBindings"%>
<%@page import="com.metalop.nashorn.utilities.Utilities"%>

<%
	String outputHtml;
	try{
		ScriptEngine nashorn =  new ScriptEngineManager().getEngineByName("nashorn");
		SimpleBindings bindings = new SimpleBindings();
		nashorn.eval(Utilities.readFromResourcesAsInputStream("React(with addons)v15.1.0.js"));
		nashorn.eval(Utilities.readFromResourcesAsInputStream("ReactDOMServerV5.1.0.js"));
		nashorn.eval(Utilities.readFromResourcesAsInputStream("babel-core-6.7.7-browser.js"),bindings);
		String unTranspiledJsx = Utilities.readFromResourcesAsString("HelloWorldReactApp.jsx");
		bindings.put("input", unTranspiledJsx);
		String transpileJavaScript = (String) nashorn.eval("Babel.transform(input, { presets: ['react'] }).code", bindings);
		nashorn.eval(transpileJavaScript);
		outputHtml = (String) nashorn.eval("ReactDOMServer.renderToString(React.createElement(HelloWorldInnerComponent));");
		pageContext.setAttribute("outputHTML", outputHtml);
		super.init();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);	
		}
	
%>
	
<html>
<head>
<title>Sample JSP page using React.js to render contents on server</title>
<meta>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>

<body>
	${outputHTML}
</body>
</html>