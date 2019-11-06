package br.com.suriacaprichos.services.interfaces;

import java.util.List;

import br.com.suriacaprichos.model.TipoCategoria;

public interface ITipoCategoria {

	public void cadastrarTipoCategoria(TipoCategoria categoria);

	public List<TipoCategoria> listarCategorias();

	public List<TipoCategoria> listarCategoriaPorNome(String nome);

}
