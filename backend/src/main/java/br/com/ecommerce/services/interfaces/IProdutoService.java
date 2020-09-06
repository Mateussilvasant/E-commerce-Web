package br.com.ecommerce.services.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.ecommerce.entities.Produto;

/**
 * @author Mateus Silva
 *
 */
public interface IProdutoService {

	public Produto cadastrarProduto(Produto produto);

	public void deletarProduto(Integer id);

	public Optional<Produto> alterarProduto(Produto produto);

	public Optional<Produto> consultarProduto(Integer id);

	public Page<Produto> listarProdutos(int page);

	public Produto consultarProdutoPorNome(String nomeProduto);

	public boolean existeProduto(Integer id);

}
