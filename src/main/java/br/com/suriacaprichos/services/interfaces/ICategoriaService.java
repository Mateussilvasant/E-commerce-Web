package br.com.suriacaprichos.services.interfaces;

import java.util.List;

import br.com.suriacaprichos.model.Categoria;
import br.com.suriacaprichos.model.Produto;

/**
 * @author Mateus Silva
 *
 */

public interface ICategoriaService {
	public int incluirCategorias(List<Categoria> categorias);

	public List<Categoria> criarCategorias(List<Integer> categoriasIDs, Produto produto);

}
