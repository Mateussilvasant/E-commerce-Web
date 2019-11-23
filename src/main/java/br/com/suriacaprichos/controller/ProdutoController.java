package br.com.suriacaprichos.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.suriacaprichos.model.Categoria;
import br.com.suriacaprichos.model.Produto;
import br.com.suriacaprichos.services.CategoriaService;
import br.com.suriacaprichos.services.ProdutoService;

/**
 * @author Mateus Silva
 *
 */

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping("/cadastrarProduto")
	public ModelAndView cadastrarProdutoForm(Produto produto) {
		ModelAndView model = new ModelAndView("cadastrarProduto");
		return model;
	}

	@RequestMapping("/gerenciar/{page}")
	public ModelAndView gerenciarProdutos(@PathVariable("page") int pagina) {
		ModelAndView model = new ModelAndView("gerenciarProdutos");

		Page<Produto> produtos = null;

		if (pagina >= 0) {
			produtos = produtoService.listarProdutos(pagina);
			model.addObject("produtosPage", produtos);
		}

		return model;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrarProduto(@Valid Produto produto,
			@RequestParam(value = "categoriasIDs") Integer[] categoriasIDs) {

		Produto produtoCadastrado = produtoService.cadastrarProduto(produto);

		List<Categoria> categorias = categoriaService.criarCategorias(Arrays.asList(categoriasIDs), produtoCadastrado);

		int categoriasQTD = categoriaService.incluirCategorias(categorias);

		ModelAndView model = new ModelAndView("redirect:/produtos/cadastrarProduto");

		if (produtoCadastrado != null && categoriasQTD == categorias.size()) {
			model.addObject("mensagemSucesso", "Produto (" + produto.getNome() + ") cadastrado com sucesso!");
		} else {
			model.addObject("mensagemErro", "Não foi possível cadastrar o produto!");
		}

		return model;
	}

	@RequestMapping("/visualizar/{idProduto}")
	public ModelAndView consultarProduto(@PathVariable("idProduto") Integer id) {
		Optional<Produto> produto = produtoService.consultarProduto(id);

		ModelAndView model = new ModelAndView("visualizarProduto");

		if (produto.isPresent()) {
			model.addObject("produto", produto.get());
		}

		return model;
	}

}
