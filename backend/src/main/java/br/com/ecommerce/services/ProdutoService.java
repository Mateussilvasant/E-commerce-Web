package br.com.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.ecommerce.entities.Produto;
import br.com.ecommerce.repositories.ProdutoRepository;
import br.com.ecommerce.services.interfaces.IProdutoService;

/**
 * @author Mateus Silva
 *
 */

@Service
public class ProdutoService implements IProdutoService {

	private ProdutoRepository repositorio;

	@Autowired
	public ProdutoService(ProdutoRepository repositorio){
		this.repositorio =  repositorio;
	}

	@Override
	public Produto cadastrarProduto(Produto produto) {
		return repositorio.save(produto);
	}

	public void deletarProduto(Integer id) {
		repositorio.deleteById(id);
	}

	@Override
	public Optional<Produto> alterarProduto(Produto produtoAlterado) {

		Optional<Produto> produtoOriginal = consultarProduto(produtoAlterado.getId());

		if (produtoOriginal.isPresent()) {

			BeanUtils.copyProperties(produtoAlterado, produtoOriginal.get(), "idProduto");

			return Optional.of(repositorio.save(produtoAlterado));
		}

		return Optional.empty();
	}

	@Override
	public Optional<Produto> consultarProduto(Integer id) {
		return repositorio.findById(id);
	}

	@Override
	public Page<Produto> listarProdutos(int page) {

		PageRequest request = PageRequest.of(page, 10);
		return repositorio.findAll(request);
	}

	@Override
	public Produto consultarProdutoPorNome(String nomeProduto) {
		Produto produto = repositorio.findByNome(nomeProduto);
		return produto;
	}

	@Override
	public boolean existeProduto(Integer id) {
		return repositorio.existsById(id);
	}

}
