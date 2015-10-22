(function(url, data, callback) {
	return jQuery.ajax({
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		'type' : 'POST',
		'url' : url,
		'data' : JSON.stringify(data),
		'dataType' : 'json',
		'success' : callback
	});
})('http://localhost:8080/login', {
	"name" : "gunther"
}, function(data, status) {
	alert("Data: " + JSON.stringify(data) + "\nStatus: " + status)
});