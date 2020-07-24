package dao.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.ConexaoSingleton;
import dao.FuncionarioDAOInterface;
import dto.FuncionarioDTO;

public class FuncionarioDAOPostgres implements FuncionarioDAOInterface {
	
	private PGSQLConnection conexao = ConexaoSingleton.getConnection();

	public void cadastrar(FuncionarioDTO novoFunc) {
		if (conexao.isConnectionValid()) {
			String[] endereco = novoFunc.getEndereco().split(" - ");
			String atributos = novoFunc.getId() + "', '" + novoFunc.getNome() + "', '" + novoFunc.getSobrenome() + "', '" + novoFunc.getNumTel() +
							   "', '" + novoFunc.getSexo() + "', '" + novoFunc.getSenha() + "', " + novoFunc.isAdmin() + ", '" + endereco[0] + "', " +
							   endereco[1] + ", '" + endereco[2];
			
			String sql = "insert into funcionario values ('" + atributos + "')";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public FuncionarioDTO buscar(FuncionarioDTO funcID) {
		if (conexao.isConnectionValid()) {
			String sql = "select * from funcionario where id = '" + funcID.getId() + "'";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					funcID.setNome(rs.getString("nome"));
					funcID.setSobrenome(rs.getString("sobrenome"));
					funcID.setNumTel(rs.getString("numtel"));
					funcID.setSexo(rs.getString("sexo"));
					funcID.setSenha(rs.getString("senha"));
					funcID.setAdmin(rs.getBoolean("isadmin"));
					
					String endereco = rs.getString("rua") + " - " + rs.getInt("numero") + " - " + rs.getString("bairro");
					funcID.setEndereco(endereco);
				}
				
			} catch (SQLException e) {}
			
		}
		
		return funcID;
	}

	public void atualizar(FuncionarioDTO funcAtual) {
		if (conexao.isConnectionValid()) {
			String[] endereco = funcAtual.getEndereco().split(" - ");
			String atributos = "nome = '" + funcAtual.getNome() + "', sobrenome = '" + funcAtual.getSobrenome() + "', numtel = '" + 
							funcAtual.getNumTel() + "', senha = '" + funcAtual.getSenha() + "', isadmin = " + funcAtual.isAdmin() + ", rua = '" + 
							endereco[0] + "', numero = " + endereco[1] + ", bairro = '" + endereco[2];
			
			String sql = "update funcionario set " + atributos + "' where id = '" + funcAtual.getId() + "'";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public void excluir(FuncionarioDTO funcID) {
		if (conexao.isConnectionValid()) {
			String sql = "delete from funcionario where id = '" + funcID.getId() + "'";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public FuncionarioDTO recuperarLista() {
		FuncionarioDTO dto = new FuncionarioDTO();
		
		if (conexao.isConnectionValid()) {
			String sql = "select * from funcionario";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					FuncionarioDTO dto2 = new FuncionarioDTO();
					
					dto2.setId(rs.getString("id"));
					dto2.setNome(rs.getString("nome"));
					dto2.setSobrenome(rs.getString("sobrenome"));
					dto2.setNumTel(rs.getString("numtel"));
					dto2.setSexo(rs.getString("sexo"));
					dto2.setSenha(rs.getString("senha"));
					dto2.setAdmin(rs.getBoolean("isadmin"));
					
					String endereco = rs.getString("rua") + " - " + rs.getInt("numero") + " - " + rs.getString("bairro");
					dto2.setEndereco(endereco);
					
					dto.addFuncionario(dto2);
				}
				
			} catch (SQLException e) {}
			
		}
		
		return dto;
	}

}
