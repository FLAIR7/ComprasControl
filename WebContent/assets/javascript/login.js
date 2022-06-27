$(document).ready(function (){
	var status = $('#status').val();
	$('username').change(function (){
		var username = $('#username').val();
		$.ajax({
			type: 'POST',
			url: 'login',
			data: {
				username: username
			}
		})
	});
	
	if(status == 'not'){
		Swal.fire({
			heightAuto: false,
			title: "User",
			text: "User does not exist!",
			icon: "error",
		});
	} else if(status == 'incorrect'){
		Swal.fire({
			heightAuto: false,
			title: "Incorrect",
			text: "Username or Password are incorrect!",
			icon: "error",
		});
	} else {
		var username = $('#username').val();
		var password = $('#password').val();
		$.ajax({
			method: 'POST',
			url: 'login',
			data: {
				username: username,
				password: password
			}
		}).done(function (){			
		})
	}
});
