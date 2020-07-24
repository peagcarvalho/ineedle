package dao.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PGSQLConnection {
	
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	private Statement estado;
	
	public PGSQLConnection(String bancoDeDados) {
		url = "jdbc:postgresql://localhost:5432/" + bancoDeDados;
		usuario = "postgres";
		senha = "admin";
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			setCon(DriverManager.getConnection(url, usuario, senha));
			setEstado(getCon().createStatement());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void desconectar() {
		try {
			getCon().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isConnectionValid() {
		try {
			return getCon().isValid(0);
		} catch (SQLException e) {}
		
		return false;
	}

	public Statement getEstado() {
		return estado;
	}

	public void setEstado(Statement estado) {
		this.estado = estado;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
