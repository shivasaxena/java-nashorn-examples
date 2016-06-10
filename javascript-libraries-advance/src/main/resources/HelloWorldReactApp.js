function getHelloWorldMarkup(){
	var reactElementUsingJsSyntax = React.createElement('H1', null, 'Hello World!');
	return ReactDOMServer.renderToString(reactElementUsingJsSyntax);
}

