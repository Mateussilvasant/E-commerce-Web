package br.com.ecommerce.services.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.ecommerce.entities.Categoria;


/**
 * @author Mateus Silva
 *
 */

public interface ICategoria {

	public Optional<Categoria> cadastrarCategoria(Categoria categoria);

	public void deletar(Integer id);

	public Optional<Categoria> consultar(Integer id);

	public List<Categoria> listarCategorias();

	public List<Categoria> listarCategoriaPorNome(String nome);

	public boolean existeCategoria(Integer id);


}
