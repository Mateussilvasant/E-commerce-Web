package br.com.suriacaprichos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.suriacaprichos.model.TipoCategoria;

/**
 * @author Mateus Silva
 *
 */

@Repository
public interface TipoCategoriaRepository extends JpaRepository<TipoCategoria, Integer> {

	@Query("SELECT tc from TipoCategoria tc WHERE tc.nome LIKE %:nome% ")
	public List<TipoCategoria> findByNameLike(@Param("nome") String nome);

}
