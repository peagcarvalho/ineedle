package dto;

import java.util.ArrayList;

public class ProdutoDTO {
	
	private int codigo;
	private String nome;
	private float preco;
	private String marca;
	private String descricao;
	private String categoria;
	private int estoque;
	private ArrayList<ProdutoDTO> produtos = new ArrayList<>();
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public ArrayList<ProdutoDTO> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(ArrayList<ProdutoDTO> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(ProdutoDTO dto) {
		produtos.add(dto);
	}
	
	public String toString() {
		return "Nome: " + getNome() + ", Marca: " + getMarca() + ", Preço: " + getPreco();
	}

}
