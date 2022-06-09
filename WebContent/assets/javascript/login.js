$("#login-in").click(function () {
	var username = $("#username").val();
	var password = $("#password").val();
	
	if(username == '' || password == '') {
		swal({
			title: "Fields are empty!",
			text: "Please check the missing field!",
			icon: "warning",
			button: "OK",
		});
	} else {
		swal({
			title: "Success!",
			text: "User logged!",
			icon: "success",
			button: "OK",
		});
	}
});

