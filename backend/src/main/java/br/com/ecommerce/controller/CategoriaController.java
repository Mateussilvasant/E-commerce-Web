package br.com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.entities.Categoria;
import br.com.ecommerce.services.CategoriaService;

/**
 * @author Mateus Silva
 *
 */

@RequestMapping(path = "/api/categorias", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class CategoriaController {

	private CategoriaService categoriaService;

	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody Categoria categoria) {
		final Optional<Categoria> categoriaSalva = categoriaService.cadastrarCategoria(categoria);

		if(categoriaSalva.isPresent()){
			return ResponseEntity.ok(categoriaSalva.get());
		} else
			return ResponseEntity.notFound().build();

	}

	@GetMapping
	public List<Categoria> listarPorNome(@RequestParam(name = "nome", required = true) @NotBlank String nome) {

		final List<Categoria> listaCategorias = categoriaService.listarCategoriaPorNome(nome);

		return listaCategorias;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
		if(categoriaService.existeCategoria(id)){
			categoriaService.deletar(id);
			return ResponseEntity.ok().build();
		} else 
			return ResponseEntity.notFound().build();
	}

}
