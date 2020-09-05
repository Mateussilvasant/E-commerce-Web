package br.com.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.model.Categoria;

/**
 * @author Mateus Silva
 *
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	@Query("SELECT c from Categoria c WHERE c.nome LIKE %:nome% ")
	public List<Categoria> findByNameLike(@Param("nome") String nome);

}
