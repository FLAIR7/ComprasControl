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
		<link rel="stylesheet" type="text/css" href="./assets/css/login.css">
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js" type="text/javascript"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js" type="text/javascript"></script>		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js" type="text/javascript"></script>
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	
		<script src="./assets/javascript/fa.js"></script>
		<script src="./assets/javascript/login.js"></script>
	
		<title>Login</title>
	</head>
	<body>				
		<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
		<div class="container">
			<div class="row px-3">
				<div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0" id="card">
					<div class="img-left d-none d-md-flex"></div>
					<div class="card-body">
						<h4 class="title text-center mt-4">
							Login into Account
						</h4>
						<form action="login" method="post" class="form-box px-3" autocomplete="off" id="form-login">
							<div class="form-input">
								<span><i class="fa fa-envelope-o"></i></span>
								<input type="text" placeholder="username" name="username" id="username" >
							</div>
							<div class="form-input">
								<span><i class="fa fa-key"></i></span>
								<input type="password" placeholder="password" name="password" id="password" >
							</div>
							
							<div class="form-input mb-3">
								<button type="submit" class="btn btn-block text-uppercase" id="login-in">
									Login
								</button>
							</div>
							
							<div class="text-center mb-2">
								Don't have an account?
								<a href="/ComprasControl/register" class="register-link">
									Register here
								</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

	</body>
	
</html>