package br.com.suriacaprichos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.suriacaprichos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
}
