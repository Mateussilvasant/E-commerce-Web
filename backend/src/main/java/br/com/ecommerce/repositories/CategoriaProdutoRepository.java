package br.com.ecommerce.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ecommerce.entities.Categoria;
import br.com.ecommerce.entities.CategoriaProduto;

public interface CategoriaProdutoRepository extends JpaRepository<CategoriaProduto, Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM CategoriaProduto AS c where c.categoria = :categoria")
	void deleteByCategoria(@Param("categoria") Categoria categoria);


}