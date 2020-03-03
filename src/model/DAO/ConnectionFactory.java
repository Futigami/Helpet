package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class ConnectionFactory {

	private static String url = "jdbc:mysql://localhost:3306/dbanimal3";
	private static String usuario = "alunos";
	private static String senha = "etec";
	
	public static Connection getConnection() throws SQLException{
		
		Connection conexao = null;
		
		conexao = DriverManager.getConnection(url, usuario, senha);
		
		return conexao;
	}
	
}
