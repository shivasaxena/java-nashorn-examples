var HelloWorldInnerComponent = React.createClass({
  render: function() {
    var text;
    if (!this.props.name) {
      text = 'React Component Says, Hello World!';
    } else {
      text = 'React Component Says, Hello '+this.props.name+'!';
    }
    return <h1>{text}</h1>;
  }
});
var ReactPageComponent = React.createClass({
  render: function() {
    return (
    <html>
    	<head>
    		<title>React Page rendered on server</title>
    	</head>
    	<body>
    		<HelloWorldInnerComponent name={this.props.name} />
    	</body>
	</html>);
  }
});