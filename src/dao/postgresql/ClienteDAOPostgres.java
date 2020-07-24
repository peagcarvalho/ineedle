package dao.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.ClienteDAOInterface;
import dao.ConexaoSingleton;
import dto.ClienteDTO;

public class ClienteDAOPostgres implements ClienteDAOInterface {
	
	private PGSQLConnection conexao = ConexaoSingleton.getConnection();

	public void cadastrar(ClienteDTO novoCliente) {
		if (conexao.isConnectionValid()) {
			String[] endereco = novoCliente.getEndereco().split(" - ");
			String atributos = novoCliente.getCpf() + "', '" + novoCliente.getNome() + "', '" + novoCliente.getSobrenome() + "', '" + novoCliente.getDataNasc() +
							   "', '" + novoCliente.getNumTel() + "', '" + endereco[0] + "', " + endereco[1] + ", '" + endereco[2];
			
			String sql = "insert into cliente values ('" + atributos + "')";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public ClienteDTO buscar(ClienteDTO clienteCPF) {
		if (conexao.isConnectionValid()) {
			String sql = "select * from cliente where cpf = '" + clienteCPF.getCpf() + "'";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					clienteCPF.setNome(rs.getString("nome"));
					clienteCPF.setSobrenome(rs.getString("sobrenome"));
					clienteCPF.setDataNasc(rs.getString("datanasc"));
					clienteCPF.setNumTel(rs.getString("numtel"));
					
					String endereco = rs.getString("rua") + " - " + rs.getInt("numero") + " - " + rs.getString("bairro");
					clienteCPF.setEndereco(endereco);
				}
				
			} catch (SQLException e) {}
			
		}
		
		return clienteCPF;
	}

	public void atualizar(ClienteDTO clienteAtual) {
		if (conexao.isConnectionValid()) {
			String[] endereco = clienteAtual.getEndereco().split(" - ");
			String atributos = "nome = '" + clienteAtual.getNome() + "', sobrenome = '" + clienteAtual.getSobrenome() + "', numtel = '" + 
							 	clienteAtual.getNumTel() + "', rua = '" + endereco[0] + "', numero = " + endereco[1] + ", bairro = '" + endereco[2];
			
			String sql = "update cliente set " + atributos + "' where cpf = '" + clienteAtual.getCpf() + "'";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public void excluir(ClienteDTO clienteCPF) {
		if (conexao.isConnectionValid()) {
			String sql = "delete from cliente where cpf = '" + clienteCPF.getCpf() + "'";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public ClienteDTO recuperarLista() {
		ClienteDTO dto = new ClienteDTO();
		
		if (conexao.isConnectionValid()) {
			String sql = "select * from cliente";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ClienteDTO dto2 = new ClienteDTO();
					
					dto2.setCpf(rs.getString("cpf"));
					dto2.setNome(rs.getString("nome"));
					dto2.setSobrenome(rs.getString("sobrenome"));
					dto2.setDataNasc(rs.getString("datanasc"));
					dto2.setNumTel(rs.getString("numtel"));
					
					String endereco = rs.getString("rua") + " - " + rs.getInt("numero") + " - " + rs.getString("bairro");
					dto2.setEndereco(endereco);
					
					dto.addCliente(dto2);
				}
				
			} catch (SQLException e) {}
			
		}
		
		return dto;
	}

}
