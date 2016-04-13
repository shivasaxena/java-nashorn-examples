// load is a nashorn function to load data
load("https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.5/handlebars.min.js");

function generateTemplate(dataObject) {
	var source = "Hello {{user}}, \n \nYour Order Number is {{orderId}}. You have " +
		"{{items.length}} items :\n" +
		"{{#items}}{{name}}, Quantity : {{quantity}} \n {{/items}}";
	var template = Handlebars.compile(source);
	var data = JSON.parse(dataObject);
	var result = template(data);
	print(result);
 
}