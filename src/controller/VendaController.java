package controller;

import dto.VendaDTO;
import model.GeradorDeRelatorioFacade;
import model.Venda;

public class VendaController {
	
	private Venda venda;
	
	public VendaController() {
		venda = new Venda();
	}
	
	public void cadastrar(VendaDTO novaVenda) { // Faz o cadastro de uma venda
		venda.cadastrar(novaVenda);
	}
	
	public VendaDTO buscar(VendaDTO vendaID) { // Realiza a busca de uma venda pelo ID
		return venda.buscar(vendaID);
	}
	
	public void atualizar(VendaDTO vendaAtual) { // Atualiza as informações de uma venda editada
		venda.atualizar(vendaAtual);
	}
	
	public void excluir(VendaDTO vendaID) { // Exclui uma venda do sistema
		venda.excluir(vendaID);
	}
	
	public VendaDTO recuperarLista() { // Recupera todos as vendas cadastradas (usado nas tabelas gerais)
		return venda.recuperarLista();
	}
	
	public void gerarNotaFiscal(VendaDTO dto) {
		GeradorDeRelatorioFacade.notaFiscal(dto);
	}
	
	public void contabilidade(VendaDTO dto) {
		GeradorDeRelatorioFacade.contabilidade(dto);
	}
	
}
