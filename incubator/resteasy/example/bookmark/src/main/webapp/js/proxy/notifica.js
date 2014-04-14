var NotificaProxy = {};

NotificaProxy.url = "api/notifica";

NotificaProxy.findAll = function($success, $error) {
	$.ajax({
		type : "GET",
		url : this.url,
		success : $success,
		error : $error
	});
};

NotificaProxy.load = function($id, $success, $error) {
	$.ajax({
		type : "GET",
		url : this.url + "/" + $id,
		success : $success,
		error : $error
	});
};

NotificaProxy.insert = function($form, $success, $error) {
	$.ajax({
		type : "POST",
		url : this.url,
		data : JSON.stringify($form),
		contentType : "application/json",
		success : $success,
		error : $error
	});
};

NotificaProxy.update = function($id, $form, $success, $error) {
	$.ajax({
		type : "POST",
		url : this.url + "/" + $id,
		data : JSON.stringify($form),
		contentType : "application/json",
		success : $success,
		error : $error
	});
};

NotificaProxy.remove = function($ids, $success, $error) {
	$.ajax({
		type : "DELETE",
		url : this.url,
		data : JSON.stringify($ids),
		contentType : "application/json",
		success : $success,
		error : $error
	});
};
