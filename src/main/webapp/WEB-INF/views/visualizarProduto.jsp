<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Visualizar Produto - ${produto.nome}</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>

	<div class="main">

		<c:import url="menuVertical.jsp"></c:import>

		<div class="container-fluid">

			<div class="text-start py-4">
				<h3>Produto - ${produto.nome}</h3>
			</div>

			<div class="row">
				<div class="col-md-1 py-4">
					<h5>Cod</h5>
					<input value="${produto.idProduto}" class="form-control"
						disabled="disabled" type="number">
				</div>
				<div class="col-md-7 py-4">
					<h5>Nome</h5>
					<input value="${produto.nome}" class="form-control"
						disabled="disabled" type="text">
				</div>
				<div class="col-md-2 py-4">
					<fmt:setLocale value="pt_BR" />
					<h5>Preço</h5>
					<input
						value="<fmt:formatNumber value="${produto.preco}" type="currency"/>"
						class="form-control" disabled="disabled" type="text">
				</div>
			</div>

			<div class="row">
				<div class="col-md-6 py-4">
					<h5>Marca</h5>
					<input value="${produto.marca} " class="form-control"
						disabled="disabled" type="text">
				</div>
				<div class="col-md-4 py-4">
					<h5>Status</h5>
					<input value="${produto.status}" class="form-control"
						disabled="disabled" type="text">
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 py-4">
					<h5>Descrição</h5>
					${produto.descricao}
				</div>
			</div>

			<div class="row">
				<div class="col-md-12 py-4">
					<table class="table">
						<thead>
							<h5>Categorias</h5>
							<tr>
								<th>Nome</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="categoria" items="${produto.categorias}">
								<tr>
									<td>${categoria.tipoCategoria.nome}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>


		</div>
	</div>

	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/popper.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/script.js"></script>
	<script src="/resources/ajax/produtos.js" charset="UTF-8"></script>
</body>
</html>