package br.com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.model.Categoria;
import br.com.ecommerce.services.CategoriaService;

/**
 * @author Mateus Silva
 *
 */

@RequestMapping("/api")
@RestController
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping("/categoria")
	public ResponseEntity<Categoria> cadastrar(@Valid @RequestBody Categoria categoria) {
		Optional<Categoria> categoriaSalva = categoriaService.cadastrarCategoria(categoria);

		if(categoriaSalva.isPresent()){
			return ResponseEntity.ok(categoriaSalva.get());
		} else
			return ResponseEntity.notFound().build();

	}

	@GetMapping("/categorias")
	public List<Categoria> listarPorNome(@RequestParam("nome") @NotBlank String nome) {

		List<Categoria> listaCategorias = categoriaService.listarCategoriaPorNome(nome);

		return listaCategorias;
	}

}
