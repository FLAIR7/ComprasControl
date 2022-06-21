<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.18.1/dist/bootstrap-table.min.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@8/dist/sweetalert2.min.css">		
		 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
    	<script src="https://unpkg.com/bootstrap-table@1.18.1/dist/bootstrap-table.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>	
        <script src="./assets/javascript/deleteProduct.js"></script>
        <script src="./assets/javascript/saveProduct.js"></script>
		<title>Account</title>
	</head>
	<body>
		<header>
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
					
					<a class="navbar-brand text-dark" href="#">ComprasControl.com</a>
					<button class="navbar-toggler" data-toggle="collapse" data-target="#navbarMenu">
						<span class="navbar-toggle-icon"></span>	
					</button>
					<div class="collapse navbar-collapse" id="navbarMenu">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active">
								<a class="nav-link text-dark" href="home">
									<i class="fas fa-home fa-sm"></i> Home
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link text-dark" href="products">
									<i class="fa fa-solid fa-store"></i> Products
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link text-dark" href="account">
									<i class="fas fa-user-circle"></i> Account
								</a>
							</li>
							<li class="nav-item">
								<a class="nav-link text-dark" href="logout">
									<i class="fa fa-sign-out"></i> Logout
								</a>
							</li>
						</ul>
					
					</div>
					
					
				</nav>
		</header>
	</body>
</html>