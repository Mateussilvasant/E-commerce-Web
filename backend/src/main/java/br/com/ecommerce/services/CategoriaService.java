package br.com.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.ecommerce.entities.Categoria;
import br.com.ecommerce.repositories.CategoriaProdutoRepository;
import br.com.ecommerce.repositories.CategoriaRepository;
import br.com.ecommerce.services.interfaces.ICategoria;

/**
 * @author Mateus Silva
 *
 */

@Service
public class CategoriaService implements ICategoria {

	private CategoriaRepository categoriaRepository;

	private CategoriaProdutoRepository categoriaProdRepository;


	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository, CategoriaProdutoRepository categoriaProdRepository){
		this.categoriaRepository = categoriaRepository;
		this.categoriaProdRepository = categoriaProdRepository;
	}

	@Override
	public Optional<Categoria> cadastrarCategoria(Categoria categoria) {
		return Optional.of(categoriaRepository.save(categoria));
	}

	@Override
	public List<Categoria> listarCategoriaPorNome(String nome) {
		List<Categoria> categorias = new ArrayList<>();
		categorias = categoriaRepository.findByNameLike(nome);
		return categorias;
	}

	@Override
	public List<Categoria> listarCategorias() {
		List<Categoria> categorias = new ArrayList<>();

		categorias = categoriaRepository.findAll();
		return categorias;
	}

	public Optional<Categoria> consultar(Integer id) {
		return categoriaRepository.findById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deletar(Integer id) {

		//Deleta todas as categorias em uso.
		categoriaProdRepository.deleteByCategoria(Categoria.builder().id(id).build());

		//Remove categoria
		categoriaRepository.deleteById(id);	

	}

	@Override
	public boolean existeCategoria(Integer id) {
		return categoriaRepository.existsById(id);
	}

}
