package br.com.ecommerce.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Mateus Silva
 *
 */

@Data
@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Produto")
	private Integer id;

	@Column(name = "nome")
	@NotBlank
	private String nome;

	@Column(name = "descricao")
	@NotBlank
	private String descricao;

	@Column(name = "marca")
	@NotBlank
	private String marca;

	@NotNull
	@Column(name = "preco")
	private double preco;

	@NotBlank
	@Column(name = "status")
	private String status;

	@JsonManagedReference
	@Valid
	@EqualsAndHashCode.Exclude	 
	@OneToMany(
		mappedBy = "produto",
		fetch = FetchType.LAZY,
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private Set<CategoriaProduto> categorias;


}
