package br.com.suriacaprichos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sc_tipo_categorias")
public class TipoCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sc_id_tipo_categoria")
	private Integer idTipoCategoria;

	@NotNull
	@Column(name = "sc_nome")
	private String nome;

	@NotNull
	@Column(name = "sc_descricao")
	private String descricao;

	public TipoCategoria() {};
	
	public TipoCategoria(Integer id) {
		setIdTipoCategoria(id);
	}

	public Integer getIdTipoCategoria() {
		return idTipoCategoria;
	}

	public void setIdTipoCategoria(Integer idTipoCategoria) {
		this.idTipoCategoria = idTipoCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "TipoCategoria [idTipoCategoria=" + idTipoCategoria + ", nome=" + nome + ", descricao=" + descricao
				+ "]";
	}

}
