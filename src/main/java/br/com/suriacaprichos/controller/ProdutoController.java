package br.com.suriacaprichos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.suriacaprichos.model.Produto;
import br.com.suriacaprichos.services.ProdutoService;

@Controller
@RequestMapping(path = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping("/cadastrarProduto")
	public String formCadastrarProduto() {
		return "cadastrarProduto";
	}

	@PostMapping("/cadastrar")
	public void cadastrarProduto(@Valid @RequestBody Produto produto) {
		produtoService.cadastrarProduto(produto);
	}

}
