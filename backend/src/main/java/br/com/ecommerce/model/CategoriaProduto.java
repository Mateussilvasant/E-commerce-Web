package br.com.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Mateus Silva
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categoria_produto")
public class CategoriaProduto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_categoria_produto")
	private Integer idCategoria;

	@NotNull
	@EqualsAndHashCode.Exclude
	@JoinColumn(name = "id_produto")
	@JsonIgnoreProperties({
		"categorias"
	})
	@ManyToOne
	private Produto produto;

	@NotNull
	@JoinColumn(name = "id_categoria")
	@EqualsAndHashCode.Exclude
	@ManyToOne
	private Categoria categoria;


}
