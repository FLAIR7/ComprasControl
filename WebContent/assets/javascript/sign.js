$("#sign-in").click(function () {
	var name = $("#name").val();
	var username = $("#username").val();
	var password = $("#password").val();
	var password2 = $("#password2").val();
	
	if(name == '' || username == '' || password == '' || password2 == '') {
		swal({
			title: "Fields are empty!",
			text: "Please check the missing field!",
			icon: "warning",
			button: "OK",
		});
	} else {
		swal({
			title: "Success!",
			text: "User signed!",
			icon: "success",
			button: "OK",
		});
	}
});