package br.com.suriacaprichos.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.suriacaprichos.model.TipoCategoria;
import br.com.suriacaprichos.repositories.TipoCategoriaRepository;
import br.com.suriacaprichos.services.interfaces.ITipoCategoria;

@Service
public class TipoCategoriaService implements ITipoCategoria {

	@Autowired
	private TipoCategoriaRepository repository;

	@Transactional
	@Override
	public void cadastrarTipoCategoria(TipoCategoria categoria) {
		repository.save(categoria);
	}

	@Transactional
	@Override
	public List<TipoCategoria> listarCategoriaPorNome(String nome) {
		List<TipoCategoria> categorias = new ArrayList<>();
		categorias = repository.findByNameLike(nome);
		return categorias;
	}

	@Override
	public List<TipoCategoria> listarCategorias() {
		List<TipoCategoria> categorias = new ArrayList<>();
		categorias = repository.findAll();
		return categorias;
	}

}
