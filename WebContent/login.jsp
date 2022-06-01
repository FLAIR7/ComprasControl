<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width", initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.1.1/css/fontawesome.min.css">
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<link rel="stylesheet" href="./assets/css/login.css">
		<title>Login</title>
	</head>
	<body>
		
		<div class="container">
			<div class="row px-3">
				<div class="col-lg-10 col-xl-9 card flex-row mx-auto px-0">
					<div class="img-left d-none d-md-flex">
					
					</div>
					<div class="card-body">
						<h4 class="title text-center mt-4">
							Entrar no Compras Control
						</h4>
						<form class="form-box px-3">
							<div class="form-input">
								<span><i class="fa fa-envelope-o"></i></span>
								<input type="text" placeholder="username" required>
							</div>
							<div class="form-input">
								<span><i class="fa fa-key"></i></span>
								<input type="password" placeholder="password" required>
							</div>
							
							<div class="form-input mb-3">
								<button type="submit" class="btn btn-block text-uppercase">
									Login
								</button>
							</div>
							
							<div class="text-center mb-2">
								Ainda não possui uma conta?
								<a href="#" class="register-link">
									Clique Aqui
								</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>