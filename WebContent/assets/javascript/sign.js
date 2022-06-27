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
			title: "Passwords Invalid",
			text: "must be 8 character, 1 lower 1 upper 1 number and 1 symbol!!",
			icon: "error",
		});
	} else if(status == "done"){
		var name = $('#name').val();
		var username = $("#username").val();
		var password = $("#password").val();
		
		$.ajax({
			method: 'POST',
			url: 'register',
			data: {
				name : name,
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

