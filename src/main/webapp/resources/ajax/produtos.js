$(document).ready(
		function() {

			$("#cadastrarProdutoID").click(function() {
				cadastrarProdutoValidacao();
			});

			$("#formCadastrarTipoCategoria").submit(function(event) {

				event.preventDefault();
				novaCategoriaSubmit();

			});

			$("#categoriaBuscadaID").keyup(function(event) {

				event.preventDefault();

				if (event.keyCode != null) {
					listarTipoCategoria(this.value);
				}
			});

			$("#tabelaCategorias").on('click', 'input[value="Adicionar"]',
					function(event) {

						event.preventDefault();
						adicionarCategoriaPage($(this));

					});

			$("#listCategorias").on('click', 'input[value="X"]',
					function(event) {
						event.preventDefault();
						removerCategoriaLista($(this));
					});

			$("#btnFecharMsgCat").click(function(event) {
				esconderMsgCadastroCategoria();
			});

		});

function removerCategoriaLista(lista) {
	lista.closest("li").remove();
}

function esconderMsgCadastroCategoria() {
	$("#mensagemResultCat").css('display', 'none');
}

function adicionarCategoriaPage(tabela) {

	tabelaRow = tabela.closest("tr");

	idCategoria = tabelaRow.find(".idField");

	nome = tabelaRow.find(".nomeCategoria").text();

	console.log(nome);

	nomeExistente = $("#listCategorias").find("#" + nome);

	if (!nomeExistente.length) {
		$("#listCategorias")
				.append(
						$('<li  class="list-group-item p-1" style="border: none"> '
								+ '<input form="formCadastrarProduto" name="categoriasIDs" type="hidden" value="'
								+ idCategoria.val()
								+ '"\> <span class="badge badge-pill badge-dark badge-pill-md nomeCat"  id="'
								+ nome
								+ '" >'
								+ nome
								+ '<input type="button" id="botaoRemover" value="X" class="btn btn-dark btn-sm"/> </span></li>'));
	}

}

function listarTipoCategoria(palavra) {

	$
			.ajax({
				url : "http://localhost:8080/tipoCategoria/listarCategoriasPorNome/"
						+ palavra,
				type : "get",
				cache : false,
				dataType : "json",
				timeout : 200000,
				contentType : "application/json; charset=utf-8",

				success : function(data) {
					var categorias = JSON.parse(JSON.stringify(data));

					$("#tabelaCategorias tr").remove();

					$
							.each(
									categorias,
									function(index, value) {
										$("#tabelaCategorias")
												.last()
												.append(
														"<tr>"
																+ "<td><input class=\"idField\" type=\"hidden\" value=\""
																+ value.idTipoCategoria
																+ "\" id=\"catID"
																+ index
																+ "\" />"
																+ "<p class=\"nomeCategoria\">"
																+ value.nome
																+ "</p>"
																+ "<small>"
																+ value.descricao
																+ "</small></td>"
																+ "<td><input type=\"button\" value=\"Adicionar\" class=\"btn btn-secondary btn-sm\" id=\"addCat\"/></td><tr> ");
									});

				},
				error : function(e) {
					$("#tabelaCategorias tr").remove();
				}

			});

}

function novaCategoriaSubmit() {

	var values = {}
	values["nome"] = $("#idNomeCategoria").val();
	values["descricao"] = $("#idDescricaoCategoria").val();

	var mensagem = $("#mensagemResultCat");

	$.ajax({
		url : "http://localhost:8080/tipoCategoria/salvarCategoria",
		data : JSON.stringify(values),
		type : "post",
		cache : false,
		timeout : 200000,
		dataType : "json",
		contentType : "application/json; charset=utf-8",
		success : function(data) {

			$("#msgCatP").text(
					'Categoria "' + values["nome"]
							+ '" cadastrada com sucesso!');
			mensagem.css('display', 'block');

			$("#cadastrarTipoCategoriaID").css('display', 'none');
		},

		error : function(e) {

			mensagem.toggleClass("alert-danger");
			$("#msgCatP").text("Ocorreu um erro, categoria não cadastrada!");
			mensagem.css('display', 'block');
		}

	});

}

function cadastrarProdutoValidacao() {

	var nome = $("#idNome");
	var descricao = $("#idDescricao");
	var marca = $("#idMarca");
	var preco = $("#idPreco");
	var listCategorias = $("#listCategorias li").length;

	nome.removeClass('is-invalid');
	descricao.removeClass('is-invalid');

	var valido = true;

	if (nome.val().length == 0) {
		nome.addClass('is-invalid');
		$('#msgValidNome').text("Por favor, informe o nome do produto!");
		valido = false;

	}
	if (descricao.val().length == 0) {
		descricao.addClass('is-invalid');
		$('#msgValidDescricao').text(
				"Por favor, informe a descrição do produto!");
		valido = false;
	}
	if (marca.val().length == 0) {
		marca.addClass('is-invalid');
		$('#msgValidMarca').text("Por favor, informe a marca do produto!");
		valido = false;
	}

	if (preco.val() < 1.00) {
		marca.addClass('is-invalid');
		$('#msgValidPreco')
				.text("Por favor, informe um preço maior que R$1,00");
		valido = false;
	}

	if (listCategorias == 0) {
		alert("Adicione ao menos uma categoria!");
		valido = false;
	}

	if (valido) {
		$("#formCadastrarProduto").submit();
	}

}
