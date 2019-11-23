package br.com.suriacaprichos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.suriacaprichos.model.TipoCategoria;
import br.com.suriacaprichos.services.TipoCategoriaService;

/**
 * @author Mateus Silva
 *
 */

@RequestMapping(path = "tipoCategoria/")
@Controller
public class TipoCategoriaController {

	@Autowired
	private TipoCategoriaService tipoCategoriaService;

	@PostMapping("/salvarCategoria")
	@ResponseBody
	public TipoCategoria cadastrarTipoCategoria(@Valid @RequestBody TipoCategoria tipoCategoria) {
		tipoCategoriaService.cadastrarTipoCategoria(tipoCategoria);
		return tipoCategoria;
	}

	@GetMapping("/listarCategoriasPorNome/{nome}")
	@ResponseBody
	public List<TipoCategoria> listarCategoriasPorNome(@Valid @PathVariable("nome") String nome) {

		List<TipoCategoria> listaCategorias = tipoCategoriaService.listarCategoriaPorNome(nome);

		return listaCategorias;
	}

}
