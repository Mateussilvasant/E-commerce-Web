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
<title>Gerenciar Produtos</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>

	<div class="main">

		<c:import url="menuVertical.jsp"></c:import>

		<div class="container-fluid">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Preço</th>
							<th>Opções</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="produto" items="${produtosPage.getContent()}">
							<tr>
								<td>${produto.nome}</td>
								<fmt:setLocale value="pt_BR" />
								<td><fmt:formatNumber value="${produto.preco}"
										type="currency" /></td>
								<td>
									<div class="pl-2">
										<input value="${produto.idProduto}" type="hidden"> <a
											href='http://localhost:8080/produtos/editar/${produto.idProduto}'>
											<small>Editar</small> <i class="fas fa-edit"></i>
										</a>
									</div>
									<div class="pl-2">
										<a
											href='http://localhost:8080/produtos/visualizar/${produto.idProduto}'>
											<small>visualizar</small> <i class="fas fa-eye"></i>
										</a>
									</div>
									<div class="pl-2">
										<a
											href='http://localhost:8080/produtos/excluir/${produto.idProduto}'>
											<small>Excluir</small> <i class="fas fa-trash-alt"></i>
										</a>
									</div>
								</td>
							</tr>
						</c:forEach>

					</tbody>

				</table>

				<nav aria-label="Outros Produtos">
					<ul class="pagination justify-content-start">
						<c:forEach var="i" begin="0"
							end="${produtosPage.getTotalPages() - 1}">
							<li class="page-item"><a class="page-link"
								href="/produtos/gerenciar/${i}">${i}</a></li>
						</c:forEach>
					</ul>
				</nav>
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