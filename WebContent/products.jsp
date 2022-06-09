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
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
		
		
		<title>Products</title>
		<style>
		body {
			background-color: white;
		}
		</style>
	</head>
	<body>
	<header>
		<div class="container">
			<div class="container-fluid">
					<nav class="navbar navbar-dark bg-primary">
						<a href="home" class="navbar-brand"><i
							class="fas fa-arrow-left fa-md"></i>
						</a>
						
						<button class="navbar-toggler" type="button" data-toggle="collapse"
	                        	data-target="#navbarsExample02" aria-controls="navbarsExample02"
	                        	aria-expanded="false" aria-label="Toggle navigation">
	                    	<span class="navbar-toggler-icon"></span>
	                	</button>
	                
		                <div class="collapse navbar-collapse" id="navbarsExample02">
		                    <ul class="navbar-nav mr-auto">
		                        <li class="nav-item"><a class="nav-link" href="home.jsp">
		                            <i class="fas fa-home fa-sm"></i> Home
		                        </a></li>
		                        <li class="nav-item"><a class="nav-link" href="categorias"><i
		                                class="fas fa-clipboard fa-sm"></i> Listas</a></li>
		                        <li class="nav-item active"><a class="nav-link" href="#"><i
		                                class="fas fa-shopping-cart fa-md"></i> Produtos</a></li>
		                    </ul>
		                </div>
		           
					</nav>
				</div>
			</div>
		</header>
		
		<section>
			<div class="container">
				<div class="container-fluid">
					<div class="table-responsive">
						<table class="table" data-toggle="table"
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
							<thead>
								<tr class="text-primary">
									<th scope="col" data-sortable="true">Nome</th>
									<th scope="col">Preço</th>
									<th scope="col">Comprado</th>
									<th scope="col">Editar</th>
									<th scope="col">Excluir</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${products}" var="prod">
									<tr>
										<td data-label="name">${prod.name}</td>
										<td data-label="price">R$ ${prod.price}</td>
										<td data-label="comprado">${prod.comprado()}</td>
										<td data-label="Editar">
											<button type="button" class="btn btn-success" data-toggle="modal" data-target="#exampleModal">
												Editar
											</button>
										</td>
										<td data-label="Excluir">
											<button class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter">
												Excluir
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</section>
		

		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Editar</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="form-group">
		        	<label for="name" class="control-label">Nome</label>
		        	<input type="text" class="form-control" value="${prod.name}" id="name">
		        </div>
		        <div class="form-group">
		        	<label for="price" class="control-label">Preço</label>
		        	<input type="text" class="form-control" value="${prod.name}" id="price">
		        </div>
		        <div class="form-group">
		        	<label for="name" class="control-label">Comprado</label>
		        	<select class="form-control">
		        		<option>Não</option>
		        		<option>Sim</option>
		        	</select>
		        </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
		        <button type="button" class="btn btn-primary">Salvar</button>
		      </div>
		    </div>
		  </div>
		</div>
				
				
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="exampleModalLongTitle">Atenção <i
                            class="fas fa-exclamation-triangle"></i></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Você tem certeza que deseja excluir o produto <strong><span id="nomeProd"></span></strong>?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="button" class="btn btn-danger" id="excluir">Excluir</button>
                </div>
            </div>
        </div>
    </div>
		
		
		
	
		
		
	</body>
</html>