package br.com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.entities.Produto;


/**
 * @author Mateus Silva
 *
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	public Produto findByNome(@Param("nome") String nome);

}
