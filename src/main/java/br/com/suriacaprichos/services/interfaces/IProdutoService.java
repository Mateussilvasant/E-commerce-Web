package br.com.suriacaprichos.services.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.suriacaprichos.model.Produto;

public interface IProdutoService {

	public Produto cadastrarProduto(Produto produto);

	public void deletarProduto(Integer id);

	public void alterarProduto(Produto produto);

	public Optional<Produto> consultarProduto(Integer id);

	public Page<Produto> listarProdutos(int page);

	public Produto consultarProdutoPorNome(String nomeProduto);

}
