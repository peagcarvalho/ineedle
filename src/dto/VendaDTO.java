package dto;

import java.util.ArrayList;

public class VendaDTO {
	
	private int id;
	private ClienteDTO cliente;
	private ProdutoDTO produto;
	private int quant;
	private float valorTotal;
	private String data;
	private ArrayList<VendaDTO> vendas = new ArrayList<>();
	
	private String dataRelatorio;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public ProdutoDTO getProduto() {
		return produto;
	}
	
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	
	public int getQuant() {
		return quant;
	}
	
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	public ArrayList<VendaDTO> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<VendaDTO> vendas) {
		this.vendas = vendas;
	}
	
	public void addVenda(VendaDTO dto) {
		vendas.add(dto);
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	public String toString() {
		return produto.toString() + ", Quantidade: " + getQuant();
	}

	public String getDataRelatorio() {
		return dataRelatorio;
	}

	public void setDataRelatorio(String dataRelatorio) {
		this.dataRelatorio = dataRelatorio;
	}
	
}