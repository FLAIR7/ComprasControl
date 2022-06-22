$(document).ready(function (){
	var status = $('#status').val();
	$('username').change(function (){
	var username = $('#username').val();					
	$.ajax({
		type: 'POST',
		url: 'register',
		data: {
			username: username
		}
	})	
});
	if(status == 'exists'){
		Swal.fire({
			heightAuto: false,
			title: "Username",
			text: "Username already exists!",
			icon: "error",
		});
	} 
	else if(status == "not"){
		Swal.fire({
			heightAuto: false,
			title: "Passwords",
			text: "Passwords are not same!",
			icon: "error",
		});
	} else if(status == "invalid"){
		Swal.fire({
			heightAuto: false,
			title: "Field Invalid",
			text: "Please chech the missing field!",
			icon: "error",
		});
	} else if(status == "done"){
		var name = $("#name").val();
		var username = $("#username").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();
						
		$.ajax({
			method: 'POST',
			url: 'register',
			data: {
				username: username,
				password: password,
			},
		}).done(function (){
			Swal.fire({
				heightAuto: false,
				title: "Good job!",
				text: "User signed!",
				icon: "success",
			});
							
		})
	}
});
