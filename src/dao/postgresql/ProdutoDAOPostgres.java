package dao.postgresql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.ConexaoSingleton;
import dao.ProdutoDAOInterface;
import dto.ProdutoDTO;

public class ProdutoDAOPostgres implements ProdutoDAOInterface {
	
	private PGSQLConnection conexao = ConexaoSingleton.getConnection();

	public void cadastrar(ProdutoDTO novoProduto) {
		if (conexao.isConnectionValid()) {
			
			String atributos = novoProduto.getNome() + "', " + novoProduto.getPreco() + ", '" + novoProduto.getMarca() + "', '" + 
							   novoProduto.getDescricao() + "', '" + novoProduto.getCategoria() + "', " + novoProduto.getEstoque();
			
			String sql = "insert into produto (nome, preco, marca, descricao, categoria, estoque) values ('" + atributos + ")";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public ProdutoDTO buscar(ProdutoDTO produtoCod) {
		if (conexao.isConnectionValid()) {
			String sql = "select * from produto where codigo = " + produtoCod.getCodigo();
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					produtoCod.setNome(rs.getString("nome"));
					produtoCod.setPreco(rs.getFloat("preco"));
					produtoCod.setMarca(rs.getString("marca"));
					produtoCod.setDescricao(rs.getString("descricao"));
					produtoCod.setCategoria(rs.getString("categoria"));
					produtoCod.setEstoque(rs.getInt("estoque"));
				}
				
			} catch (SQLException e) {}
			
		}
		
		return produtoCod;
	}

	public void atualizar(ProdutoDTO produtoAtual) {
		if (conexao.isConnectionValid()) {
			String atributos = produtoAtual.getNome() + "', preco = " + produtoAtual.getPreco() + ", marca = '" + produtoAtual.getMarca() + "', descricao = '" + 
							   produtoAtual.getDescricao() + "', categoria = '" + produtoAtual.getCategoria() + "', estoque = " + produtoAtual.getEstoque();
			
			String sql = "update produto set nome = '" + atributos + " where codigo = " + produtoAtual.getCodigo();
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public void excluir(ProdutoDTO produtoCod) {
		if (conexao.isConnectionValid()) {
			String sql = "delete from produto where codigo = " + produtoCod.getCodigo();
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				ps.executeUpdate();
				
			} catch (SQLException e) {}
			
		}
	}

	public ProdutoDTO recuperarLista() {
		ProdutoDTO dto = new ProdutoDTO();
		
		if (conexao.isConnectionValid()) {
			String sql = "select * from produto order by codigo";
			
			try {
				PreparedStatement ps = conexao.getCon().prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ProdutoDTO dto2 = new ProdutoDTO();
					
					dto2.setCodigo(rs.getInt("codigo"));
					dto2.setNome(rs.getString("nome"));
					dto2.setPreco(rs.getFloat("preco"));
					dto2.setMarca(rs.getString("marca"));
					dto2.setDescricao(rs.getString("descricao"));
					dto2.setCategoria(rs.getString("categoria"));
					dto2.setEstoque(rs.getInt("estoque"));
					
					dto.addProduto(dto2);
				}
				
			} catch (SQLException e) {}
			
		}
		
		return dto;
	}

}
