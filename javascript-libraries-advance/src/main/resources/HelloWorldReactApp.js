function getHelloWorldMarkup(){
	return ReactDOMServer.renderToString(React.createElement('H1', null, 'Hello World!'));
}

