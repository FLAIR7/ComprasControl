$(document).ready(function (){
	$('#form-sign').submit(function (e){
		e.preventDefault();
		var name = $("#name").val();
		var username = $("#username").val();
		var password = $("#password").val();
		var password2 = $("#password2").val();
		
		if(password != password2){
			Swal.fire({
				heightAuto: false,
  				icon: 'error',
  				title: 'Passwords not the same!',
  				text: 'Please check the passwords!',
			})
		}
		else if(name == '' || username == '' || password == '' || password2 == '') {
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
				Swal.fire({
					heightAuto: false,
					title: "Good job!",
					text: "User signed!",
					icon: "success",
				});
				setTimeout(function (){
					$('#login-in').trigger("click");
				}, 5000);
				setTimeout(function () {
                    window.location.replace("login.jsp")
                }, 3000);
			})
		}
	});
});

//sign();