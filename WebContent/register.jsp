<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.1/css/fontawesome.min.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@8/dist/sweetalert2.min.css">		
		<link rel="stylesheet" href="./assets/css/login.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="./assets/javascript/fa.js"></script>
		<script src="./assets/javascript/sign.js"></script>
		<style>
		.img-left {
			width: 45%;
			background: url("./assets/css/img/banner2.jpg") right;
			background-size: cover;
		}
		
		</style>
		<title>Sign Up</title>
	</head>
	<body>		
		<div class="container">
			<div class="row px-3">
				<div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
					<div class="img-left d-none d-md-flex">

					</div>
					<div class="card-body">
						<h4 class="title text-center mt-4">
							Sign Up
						</h4>
						<form action="register" class="form-box px-3" method="post" autocomplete="off" id="form-sign">
							<div class="form-input">
								<span><i class="fa fa-user"></i></span>
								<input id="name" type="text" placeholder="name" name="name" >
							</div>
							<div class="form-input">
								<span><i class="fa fa-envelope-o"></i></span>
								<input type="text" placeholder="username" name="username" id="username" >
							</div>
							<div class="form-input">
								<span><i class="fa fa-lock"></i></span>
								<input type="password" placeholder="password" name="password" pattern="^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,25}$" title="Minimo de 8 characters. Deve ter pelo menos 1 caractere especial, um número e uma letra Maiscula" id="password" >
							</div>
							
							<div class="form-input">
								<span><i class="fa fa-lock"></i></span>
								<input type="password" placeholder="same password" pattern="^(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,25}$" title="Minimo de 8 characters. Deve ter pelo menos 1 caractere especial, um número e uma letra Maiscula" name="password2" id="password2" >
							</div>
							
							<div class="form-input mb-3">
								<button type="submit" class="btn btn-block text-uppercase" id="sign-in">
									Join Now!
								</button>
							</div>
							
							<div class="text-center mb-2">
								Already have an Account?
								<a href="/ComprasControl/login" class="register-link">
									Sign in
								</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
	</body>	
	
</html>