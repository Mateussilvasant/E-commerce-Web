package br.com.suriacaprichos.services.interfaces;

import java.util.List;
import java.util.Optional;

import br.com.suriacaprichos.model.Produto;

public interface IProdutoService {

	public void cadastrarProduto(Produto produto);

	public void deletarProduto(Integer id);

	public void alterarProduto(Produto produto);

	public Optional<Produto> consultarProduto(Integer id);

	public List<Produto> listarProdutos();

}
