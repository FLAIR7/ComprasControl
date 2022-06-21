$(document).ready(function (){
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
});
//login();
