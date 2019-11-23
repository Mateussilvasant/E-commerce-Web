package br.com.suriacaprichos.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author Mateus Silva
 *
 */

@Entity
@Table(name = "sc_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sc_id_Produto")
	private Integer idProduto;

	@Column(name = "sc_nome")
	@NotBlank
	private String nome;

	@Column(name = "sc_descricao")
	@NotBlank
	private String descricao;

	@Column(name = "sc_marca")
	@NotBlank
	private String marca;

	@Column(name = "sc_preco")
	private double preco;

	@Column(name = "sc_status")
	private String status;

	@JoinColumn(name = "sc_id_produto")
	@OneToMany()
	private List<Categoria> categorias;

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", descricao=" + descricao + ", marca=" + marca
				+ ", preco=" + preco + ", status=" + status + ", categorias=" + categorias + "]";
	}

}
