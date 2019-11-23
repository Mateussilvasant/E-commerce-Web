package br.com.suriacaprichos.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.suriacaprichos.model.Categoria;
import br.com.suriacaprichos.model.Produto;
import br.com.suriacaprichos.repositories.CategoriaRepository;
import br.com.suriacaprichos.services.interfaces.ICategoriaService;

/**
 * @author Mateus Silva
 *
 */

@Service
public class CategoriaService implements ICategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional
	@Override
	public int incluirCategorias(List<Categoria> categorias) {
		return categoriaRepository.saveAll(categorias).size();
	}

	public List<Categoria> criarCategorias(List<Integer> categoriasIDs, Produto produto) {
		List<Categoria> categorias = new ArrayList<>();

		categoriasIDs.forEach(i -> {
			Categoria categoria = new Categoria();
			categoria.criarCategoria(i, produto);

		});

		return categorias;
	}

}
