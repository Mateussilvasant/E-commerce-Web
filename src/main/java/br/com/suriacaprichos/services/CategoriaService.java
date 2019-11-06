package br.com.suriacaprichos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.suriacaprichos.model.Categoria;
import br.com.suriacaprichos.repositories.CategoriaRepository;
import br.com.suriacaprichos.services.interfaces.ICategoriaService;

@Service
public class CategoriaService implements ICategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional
	@Override
	public int incluirCategorias(List<Categoria> categorias) {
		return categoriaRepository.saveAll(categorias).size();
	}

}
