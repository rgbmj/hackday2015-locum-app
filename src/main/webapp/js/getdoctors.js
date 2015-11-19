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
})('getcandidates', {
	"name" : "hospital"
}, function(data, status) {
	alert("Data: " + JSON.stringify(data) + "\nStatus: " + status)
});