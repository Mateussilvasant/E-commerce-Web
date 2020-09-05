package br.com.ecommerce.services.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.ecommerce.model.Categoria;


/**
 * @author Mateus Silva
 *
 */

public interface ICategoria {

	public Optional<Categoria> cadastrarCategoria(Categoria categoria);

	public List<Categoria> listarCategorias();

	public List<Categoria> listarCategoriaPorNome(String nome);

}
