package br.com.ecommerce.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.model.Produto;
import br.com.ecommerce.services.ProdutoService;

/**
 * @author Mateus Silva 
 */

@RestController
@RequestMapping("/api")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@PostMapping("/produto")
	public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) {

		Produto produtoCadastrado = produtoService.cadastrarProduto(produto);

		if (produtoCadastrado != null) {
			return ResponseEntity.ok(produtoCadastrado);
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> alterar(@Valid @RequestBody Produto produto, @PathVariable("id") Integer id) {

		Optional<Produto> produtoOpt = produtoService.alterarProduto(produto);

		if (produtoOpt.isPresent()) {
			return ResponseEntity.ok(produtoOpt.get());
		} else
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
	}


	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> consultar(@PathVariable("id") Integer id) {
		Optional<Produto> produto = produtoService.consultarProduto(id);

		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		} else
			return ResponseEntity.notFound().build();
	}


	@GetMapping("/produtos")
	public Page<Produto> listar(@RequestParam("page") @Min(0) int pagina) {

		Page<Produto> produtos = produtoService.listarProdutos(pagina);

		return produtos;
	}
	
}
