<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.entities.User" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="./assets/css/home.css">
		<title>Home</title>
	</head>
	<body>
		<div class="container">
			<div class="cartao text-center">
				<h2 class="titulo card-title mt-3 text-center">
					Welcome, ${user.username}
				</h2>
				<div class="mt-3">
					<div class="form-group">
						<div class="ajuda">
							<a href="products">
								<button>
									<i class="fa fa-solid fa-store"></i> Products
								</button>
							</a>
						</div>
					</div>
					<div class="form-group">
						<div class="ajuda">
							<a href="list">
								<button>
									<i class="fa fa-solid fa-list"></i> Your List
								</button>
							</a>
						</div>
					</div>
					<div class="form-group">
						<div class="conta">
							<a href="account">
								<button>
									<i class="fas fa-user-circle"></i> Account
								</button>
							</a>
						</div>
					</div>
					<div class="form-group">
						<div class="ajuda">
							<a href="help">
								<button>
									<i class="fa-solid fa-question"></i> Help
								</button>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>