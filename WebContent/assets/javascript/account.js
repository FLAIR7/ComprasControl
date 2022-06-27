var idUser = 0;

$(document).on('show.bs.modal', '#exampleModal', function (event){
	$('#exampleModal').modal('show')
	var button = $(event.relatedTarget);
	//var clickedButtonId = button.data('id');
	idUser = button.data('id');
})

function editUser(){
	let name = $('#name').val();
	let username = $('#username').val();
	
	if(!name || !username){
		Swal.fire({
				heightAuto: false,
  				icon: 'error',
  				title: 'User invalid!',
  				text: 'Please check some field!',
			})
	} else if(name && username){
		$.ajax({
			method: "POST",
			url: "account?action=edit",
			data : {
				idUser : idUser,
				name : name,
				username : username,
			}
		}).done(function (){
			$('#exampleModal').modal('hide')
			window.setTimeout(function(){location.reload()},100)
		})
	}
}

function editPassword(){
	let old = $('#old').val();
	let password1 = $('#password1').val();
	let password2 = $('#password2').val();
	let idUser = $('#idpassword').val();
	
	if(password1 != password2){
		Swal.fire({
			heightAuto: false,
  			icon: 'error',
  			title: 'Password invalid!',
  			text: 'Passwords are not equal!',
		})
	} else if(checkPassword(password1) && checkPassword(password2)){
		$.ajax({
			method: "POST",
			url: "account?action=change-pass",
			data : {
				idUser : idUser,
				old : old,
				password1 : password1,
				password2 : password2,
			}
		}).done(function (){
			$('#exampleModalPassword').modal('hide')
			window.setTimeout(function(){location.reload()},100)
		})
	}
}

function checkPassword(str){
	var re = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
	return re.test(str);
}


