package br.com.suriacaprichos.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.suriacaprichos.model.Produto;
import br.com.suriacaprichos.repositories.ProdutoRepository;
import br.com.suriacaprichos.services.interfaces.IProdutoService;

@Service
public class ProdutoService implements IProdutoService {

	@Autowired
	private ProdutoRepository repositorio;

	@Transactional
	@Override
	public Produto cadastrarProduto(Produto produto) {
		return repositorio.save(produto);
	}

	@Transactional
	public void deletarProduto(Integer id) {
		repositorio.deleteById(id);
	}

	@Transactional
	@Override
	public void alterarProduto(Produto produtoAlterado) {

		Optional<Produto> produtoOriginal = consultarProduto(produtoAlterado.getIdProduto());

		if (produtoOriginal.isPresent()) {
			BeanUtils.copyProperties(produtoAlterado, produtoOriginal, "idProduto");
			repositorio.save(produtoAlterado);
		}

	}

	@Transactional
	@Override
	public Optional<Produto> consultarProduto(Integer id) {
		return repositorio.findById(id);
	}

	@Transactional
	@Override
	public Page<Produto> listarProdutos(int page) {

		PageRequest request = PageRequest.of(page, 10);
		return repositorio.findAll(request);
	}

	@Transactional
	@Override
	public Produto consultarProdutoPorNome(String nomeProduto) {
		Produto produto = repositorio.findByNome(nomeProduto);
		return produto;
	}

}
