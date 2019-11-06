<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Cadastrar Produto</title>
<link href="/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/css/style.css" rel="stylesheet">
</head>
<body>

	<div class="text-center p-4">
		<h3>Cadastrar Produto</h3>
	</div>

	<form id="formCadastrarProduto" action="cadastrar" method="post"></form>
	<form id="formCadastrarTipoCategoria"></form>

	<div class="container">

		<c:choose>
			<c:when test="${not empty param.mensagemSucesso}">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					${param.mensagemSucesso}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:when>
			<c:when test="${not empty param.mensagemErro}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					${param.mensagemErro}
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

			</c:when>
		</c:choose>

		<div class="form-group">

			<label class="pb-2" for="idNome">Nome: </label> <input
				form="formCadastrarProduto" id="idNome" type="text"
				class="form-control" name="nome" />
			<div id="msgValidNome" class="invalid-feedback"></div>

			<label class="py-2" for="idDescricao">Descrição: </label>
			<textarea form="formCadastrarProduto" id="idDescricao"
				class="form-control pb-2" name="descricao" maxlength="500"></textarea>
			<div id="msgValidDescricao" class="invalid-feedback"></div>

			<label class="py-2" for="idMarca">Marca: </label> <input
				form="formCadastrarProduto" class="form-control" type="text"
				id="idMarca" name="marca" />
			<div id="msgValidMarca" class="invalid-feedback"></div>

			<label class="py-2" for="idPreco">Preço: </label> <input
				form="formCadastrarProduto" step="0.01" placeholder="0.00"
				type="number" class="form-control" name="preco" id="idPreco" />
			<div id="msgValidPreco" class="invalid-feedback"></div>

			<div class="form-group py-4">
				<form:radiobutton form="formCadastrarProduto" path="produto.status"
					checked="checked" value="Disponível" />
				Disponível
				<form:radiobutton form="formCadastrarProduto" path="produto.status"
					value="Indisponível" />
				Indisponível
			</div>
		</div>


		<div class="card">

			<div class="card-header">
				<div class="row">
					<div class="col-lg-5 col-sm-6 pt-2">
						<h5>Categorias</h5>
					</div>

					<div class="col-lg-6 col-sm-3 pt-2">
						<input class="form-control" type="search" id="categoriaBuscadaID" />

					</div>
					<div class="col-lg-1 col-sm-3 pt-2">
						<input onclick="novaCategoria()" id="novaCategoriaID"
							class="btn btn-primary" type="button" value="Novo" />
					</div>
				</div>
				<div class="card-subtitle pt-2">
					<p>
						<small>Pesquise uma categoria ou crie uma nova.</small>
					</p>
				</div>

			</div>

			<div class="card-body">

				<div style="display: none" id="mensagemResultCat"
					class="alert alert-success alert-dismissible fade show"
					role="alert">
					<p id="msgCatP" class="mb-0"></p>
					<button id="btnFecharMsgCat" type="button" class="close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div id="cadastrarTipoCategoriaID" class="form-group"
					style="display: none">
					<c:import url="cadastrarTipoCategoria.jsp"></c:import>
				</div>

				<div class="table-responsive-sm">
					<table id="tabelaCategorias" class="table">
						<thead>
							<tr>
								<th scope="col">Nome</th>
								<th scope="col">Opções</th>
							</tr>
						</thead>

						<tbody>
						</tbody>
					</table>

				</div>

				<ul id="listCategorias"
					class="d-flex flex-wrap list-group-flush pl-4">
				</ul>



			</div>
		</div>

		<div class="d-flex justify-content-end form-group p-4">
			<input id="cadastrarProdutoID" class="btn btn-primary" type="button"
				value="Cadastrar" />
		</div>

	</div>

	<script src="/resources/js/jquery-3.4.1.min.js"></script>
	<script src="/resources/js/popper.min.js"></script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/script.js"></script>
	<script src="/resources/ajax/produtos.js" charset="UTF-8"></script>
</body>
</html>