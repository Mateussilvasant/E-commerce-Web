package br.com.suriacaprichos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Mateus Silva
 *
 */
@Entity
@Table(name = "sc_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sc_id_categoria")
	private Integer idCategoria;

	@NotNull
	@JoinColumn(name = "sc_id_produto")
	@ManyToOne
	private Produto produto;

	@NotNull
	@JoinColumn(name = "sc_id_tipo_categoria")
	@ManyToOne
	private TipoCategoria tipoCategoria;

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public TipoCategoria getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(TipoCategoria tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public Categoria criarCategoria(int tipoCategoria, Produto produto) {
		Categoria categoria = new Categoria();
		categoria.setTipoCategoria(new TipoCategoria(tipoCategoria));
		categoria.setProduto(produto);
		return categoria;
	}

}
