<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model.entities.Product" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		
		<title>My List</title>
		<style>
		body {
			background-color: white;
		}
		.maintxt{
			height: 300px;
			background-image: url(./assets/css/img/list.jpg);
			background-repeat: no-repeat;
			background-size: cover;
		}
		
		</style>
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
								<a class="nav-link text-dark" href="logout">
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
			<div>
				<div class="">
					<div class="maintxt d-flex align-items-center justify-content-around">
						<div class="">
							<h1 class="title text-light text-uppercase display-4">${user.username}</h1>
							<p class="text-light h6">Would you like to add a product to your list?</p>
							<button class="btn btn-light" data-toggle="modal" 
							data-target="#exampleModal" data-name="${prod.name}" 
							data-id="${prod.productId}">
							Add Product</button>
						</div>
						<div></div>
					</div>
				</div>
			</div>			
				
		</header>
		
	
		
		<section>
			<div class="container-fluid">
				<div class="">
					<div class="table-responsive">
						<table class="table table-borderless" id="table" data-toggle="table"
                           data-search="true"
                           data-pagination="true"
                           data-show-columns="true"
                           data-toolbar="#toolbar"
                           data-search-accent-neutralise="true"
                           data-search-align="left"
                           data-pagination="true"
                           data-pagination-h-align="left"
                           data-pagination-detail-h-align="right"
                           data-buttons="buttons"
                           data-filter-control="true">
							<thead class="thead-primary">
								<tr class="text-dark">
									<th scope="col" style="text-align: center">Name</th>
									<th scope="col" style="text-align: center">Price</th>
									<th scope="col" style="text-align: center">Purchased</th>
									<th scope="col" style="text-align: center">Edit</th>
									<th scope="col" style="text-align: center">Delete</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${products}" var="prod">
									<tr>
										<td data-label="name" style="text-align: left">${prod.name}</td>
										<td data-label="price" style="text-align: left">R$ ${prod.price}</td>
										<td data-label="comprado" style="text-align: left">${prod.comprado()}</td>
										<td style="text-align: left">
											<button type="button" 
											class="btn btn-dark" data-toggle="modal" 
											data-target="#exampleModal" data-id="${prod.productId}"
											data-name="${prod.name}">
												Edit
											</button>
										</td>
										<td  style="text-align: left">
											<button type="button"
											
											class="btn btn-light" data-toggle="modal" data-target="#exampleModalCenter"
											data-name="${prod.name}" data-id="${prod.productId}">
												Delete
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				<script> if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent)) $('#table').addClass("table-sm");</script>
				</div>
			</div>
		</section>
		

		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Edit</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="form-group">
		        	<label for="name" class="control-label">Name</label>
		        	<input type="text" class="form-control" value="${prod.name}" id="name">
		        </div>
		        <div class="form-group">
		        	<label for="price" class="control-label">Price</label>
		        	<input type="text" class="form-control" value="${prod.price}" id="price">
		        </div>
		        <div class="form-group">
		        	<label for="name" class="control-label">Purchase</label>
		        	<select class="form-control" id="myselect">
		        		<option value="false">No</option>
		        		<option value="true">Yes</option>
		        	</select>
		        </div>
		      </div>
		      <div class="modal-footer">
		      	 <input name="id" type="hidden" class="form-control" id="id" value="${prod.productId}">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
		        <button type="button" class="btn btn-primary" onclick="saveProduct()" id="salvar">Save</button>
		      </div>
		    </div>
		  </div>
		</div>
				
				
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	        <div class="modal-dialog modal-dialog-centered" role="document">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <h5 class="modal-title text-danger" id="exampleModalLongTitle">Warning <i
	                            class="fas fa-exclamation-triangle"></i></h5>
	                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                </div>
	                <div class="modal-body">
	                    Are you sure you want to delete this item <strong><span id="nomeProd"></span></strong>?
	                </div>
	                <div class="modal-footer">
	                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
	                    <button type="button" class="btn btn-danger" id="excluir">Delete</button>
	                </div>
	            </div>
	        </div>
    	</div>
		
		
	</body>
</html>