package br.com.suriacaprichos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.suriacaprichos.model.Categoria;
import br.com.suriacaprichos.model.Produto;
import br.com.suriacaprichos.model.TipoCategoria;
import br.com.suriacaprichos.repositories.CategoriaRepository;
import br.com.suriacaprichos.services.CategoriaService;
import br.com.suriacaprichos.services.ProdutoService;
import br.com.suriacaprichos.services.TipoCategoriaService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping("/cadastrarProduto")
	public ModelAndView cadastrarProdutoForm(Produto produto) {
		return new ModelAndView("cadastrarProduto");
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrarProduto(@Valid Produto produto,
			@RequestParam(value = "categoriasIDs") Integer[] categoriasIDs, RedirectAttributes redirect) {

		Produto produtoCadastrado = produtoService.cadastrarProduto(produto);

		List<Categoria> categorias = getCategorias(Arrays.asList(categoriasIDs), produtoCadastrado);

		int categoriasQTD = categoriaService.incluirCategorias(categorias);

		ModelAndView model = new ModelAndView("redirect:/produtos/cadastrarProduto");

		if (produtoCadastrado != null && categoriasQTD == categorias.size()) {
			model.addObject("mensagemSucesso", "Produto (" + produto.getNome() + ") cadastrado com sucesso!");
		} else {
			model.addObject("mensagemErro", "Não foi possível cadastrar o produto!");
		}

		return model;
	}

	private List<Categoria> getCategorias(List<Integer> categoriasIDs, Produto produto) {
		List<Categoria> categorias = new ArrayList<>();

		categoriasIDs.forEach(i -> {
			Categoria categoria = new Categoria();
			categoria.setTipoCategoria(new TipoCategoria(i));
			categoria.setProduto(produto);
			categorias.add(categoria);

		});

		return categorias;
	}

	@RequestMapping("/consultar/{nomeProduto}")
	public Produto consultarProduto(@PathVariable("nomeProduto") String nomeProduto) {
		Produto produto = produtoService.consultarProdutoPorNome(nomeProduto);

		return produto;
	}

}
