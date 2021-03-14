package dao.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import controller.ClienteController;
import controller.ProdutoController;
import dao.ConexaoSingleton;
import dao.VendaDAOInterface;
import dto.ClienteDTO;
import dto.ProdutoDTO;
import dto.VendaDTO;

public class VendaDAOPostgres implements VendaDAOInterface {
	
	private PGSQLConnection conexao = ConexaoSingleton.getConnection();

	public void cadastrar(VendaDTO novaVenda) {
		if (conexao.isConnectionValid()) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dataAtual = sdf.format(new Date(System.currentTimeMillis()));
			
			String atributos = novaVenda.getCliente().getCpf() + "', " + novaVenda.getProduto().getCodigo() + ", " + novaVenda.getQuant() + ", '" + 
							   dataAtual;
			
			System.out.println(novaVenda.getCliente().getCpf());
			System.out.println(novaVenda.getProduto().getCodigo());
			System.out.println(novaVenda.getQuant());
			System.out.println(dataAtual);
			String sql = "insert into venda (cpf_cliente, cod_prod, quant, data_reg) values ('" + atributos + "')";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public VendaDTO buscar(VendaDTO vendaID) {
		ClienteController ctrl = new ClienteController();
		ProdutoController ctrl2 = new ProdutoController();
		
		if (conexao.isConnectionValid()) {
			String sql = "select * from venda where id = " + vendaID.getId();
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					vendaID.setQuant(rs.getInt("quant"));
					vendaID.setValorTotal(rs.getFloat("valor_total"));
					vendaID.setData(rs.getString("data_reg"));
					
					ClienteDTO clienteDTO = new ClienteDTO();
					clienteDTO.setCpf(rs.getString("cpf_cliente"));
					vendaID.setCliente(ctrl.buscar(clienteDTO));
					
					ProdutoDTO produtoDTO = new ProdutoDTO();
					produtoDTO.setCodigo(rs.getInt("cod_prod"));
					vendaID.setProduto(ctrl2.buscar(produtoDTO));
				}
				
			} catch (SQLException e) {}
			
		}
		
		return vendaID;
	}

	public void atualizar(VendaDTO vendaAtual) {}

	public void excluir(VendaDTO vendaID) {
		if (conexao.isConnectionValid()) {
			String sql = "delete from venda where id = " + vendaID.getId();
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public VendaDTO recuperarLista() {
		ClienteController ctrl = new ClienteController();
		ProdutoController ctrl2 = new ProdutoController();
		VendaDTO dto = new VendaDTO();
		
		if (conexao.isConnectionValid()) {
			String sql = "select * from venda";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					VendaDTO dto2 = new VendaDTO();
					
					dto2.setId(rs.getInt("id"));
					dto2.setQuant(rs.getInt("quant"));
					dto2.setValorTotal(rs.getFloat("valor_total"));
					dto2.setData(rs.getString("data_reg"));
					
					ClienteDTO clienteDTO = new ClienteDTO();
					clienteDTO.setCpf(rs.getString("cpf_cliente"));
					dto2.setCliente(ctrl.buscar(clienteDTO));
					
					ProdutoDTO produtoDTO = new ProdutoDTO();
					produtoDTO.setCodigo(rs.getInt("cod_prod"));
					dto2.setProduto(ctrl2.buscar(produtoDTO));
					
					dto.addVenda(dto2);
				}
				
			} catch (SQLException e) {}
			
		}
		
		return dto;
	}

}
