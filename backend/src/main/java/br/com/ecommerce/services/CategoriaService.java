package br.com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.model.Categoria;
import br.com.ecommerce.repositories.CategoriaRepository;
import br.com.ecommerce.services.interfaces.ICategoria;


/**
 * @author Mateus Silva
 *
 */

@Service
public class CategoriaService implements ICategoria {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public Optional<Categoria> cadastrarCategoria(Categoria categoria) {
		return Optional.of(repository.save(categoria));
	}

	@Override
	public List<Categoria> listarCategoriaPorNome(String nome) {
		List<Categoria> categorias = new ArrayList<>();
		categorias = repository.findByNameLike(nome);
		return categorias;
	}

	@Override
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = new ArrayList<>();
		categorias = repository.findAll();
		return categorias;
	}

}
