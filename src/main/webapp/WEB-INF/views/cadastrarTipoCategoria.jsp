<div class="container">
	<label for="idNomeCategoria">Nome: </label> <input 
		form="formCadastrarTipoCategoria" id="idNomeCategoria" type="text"
		class="form-control" name="nome" required="required" /> <label class="py-2"
		for="idDescricaoCategoria">Descrição: </label>
	<textarea form="formCadastrarTipoCategoria" id="idDescricaoCategoria"
		class="form-control" name="descricao" maxlength="500"
		required="required"></textarea>

	<div class="d-flex justify-content-end form-group py-4">
		<input form="formCadastrarTipoCategoria" id="cadastrarNovaCategoriaID"
			class="btn btn-primary" type="submit" value="Salvar" />
	</div>
</div>