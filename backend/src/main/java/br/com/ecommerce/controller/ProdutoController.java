package br.com.ecommerce.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.entities.Produto;
import br.com.ecommerce.services.ProdutoService;

/**
 * @author Mateus Silva
 */

@RequestMapping(path = "/api/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ProdutoController {

	private ProdutoService produtoService;

	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> cadastrar(@Valid @RequestBody Produto produto) {

		final Produto produtoCadastrado = produtoService.cadastrarProduto(produto);

		if (produtoCadastrado != null) {
			return ResponseEntity.ok(produtoCadastrado);
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> alterar(@Valid @RequestBody Produto produto, @PathVariable("id") Integer id) {

		final Optional<Produto> produtoOpt = produtoService.alterarProduto(produto);

		if (produtoOpt.isPresent()) {
			return ResponseEntity.ok(produtoOpt.get());
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@GetMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> consultar(@PathVariable("id") Integer id) {
		final Optional<Produto> produto = produtoService.consultarProduto(id);

		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		} else
			return ResponseEntity.notFound().build();
	}

	@GetMapping
	public Page<Produto> listar(@RequestParam(name = "page", required = false, defaultValue = "0") @Min(0) int pagina) {

		final Page<Produto> produtos = produtoService.listarProdutos(pagina);

		return produtos;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
		if (produtoService.existeProduto(id)) {
			produtoService.deletarProduto(id);
			return ResponseEntity.ok().build();
		} else
			return ResponseEntity.noContent().build();
	}

}
