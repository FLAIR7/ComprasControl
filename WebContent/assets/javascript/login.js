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
			Swal.fire({
				heightAuto: false,
				title: "Good job!",
				text: "Login accepted!",
				icon: "success",
			});
			window.location.replace("home.jsp")
		})
	}
});


/*$(document).ready(function (){
	$('#form-login').submit(function (e){
		e.preventDefault();
		var username = $("#username").val();
		var password = $("#password").val();
		
		if(username == '' || password == '') {
			Swal.fire({
				heightAuto: false,
  				icon: 'error',
  				title: 'Fields are empty!',
  				text: 'Please check the missing field!',
			})
		} else {
			$.ajax({
				method: 'POST',
				url: 'login',
				data: {
					username: username,
					password: password,
				}
			}).done(function (){
				setTimeout(function (){
					$('#login-in').trigger("click");
				}, 100);
				setTimeout(function () {
                    window.location.replace("home.jsp")
                }, 100);
			}).fail(function (){
				Swal.fire({
  					icon: 'error',
  					title: 'Something went wrong!',
  					text: 'You should create an account first!',
				})
			})
		}
	});
});*/

