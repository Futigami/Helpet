package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Login;

public class UsuarioDAO {

	public Login autenticar(Login login) {
		
		Connection con = null;
		String sql = "";
		
		sql = "select * from cadastrousuario where nomeUsuario = '" + login.getUsuario() + "' and senhaUsuario = '" + login.getSenha() + "' " ;
		
		try {
			// Estabelece a conex�o com o Banco
			con = ConnectionFactory.getConnection();
			// Cria um objeto do tipo Statement				
			Statement stmt = con.createStatement();
			// Executa a string SQL e atribui resultado da consulta em um ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			// Tenta posicionar o ponteiro no pr�ximo registro do rs
			// Se conseguir (o select retornou um resultado) retorna true, sen�o (se o rs estiver vazio) ocorrer� uma exception
			while(rs.next()){
				// Recupera os dados do registro encontrado no banco e armazena no objeto usuario
				login.setRegistro(rs.getInt("idCadastro"));
				login.setUsuario(rs.getString("nomeUsuario"));

			}			
			// Fecha o ResultSet
			stmt.close();
			rs.close();
			
		} catch (SQLException erro) {  // Captura erros referente a instru��es SQL
			erro.printStackTrace();
			
		} catch (Exception erro) { // Captura erros imprevistos
			erro.printStackTrace();
		
		} finally{ // Ser� executado ocorrendo ou n�o um erro no bloco try			
			try{
				// Fecha a conex�o
				con.close();				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return login;
		
	}
	
	public void inserir(Login loginInserir) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into cadastrousuario (nomeUsuario, senhaUsuario, enderecoUsuario, emailUsuario, celularUsuario)"+
			"								values( ?, ?, ?, ?, ?);";
			
			ps = con.prepareStatement(sql);	
			
			ps.setString(1, loginInserir.getUsuario());
			ps.setString(2, loginInserir.getSenha());
			ps.setString(3, loginInserir.getEndereco());
			ps.setString(4, loginInserir.getEmail());
			ps.setString(5, loginInserir.getCelular());
			
			ps.executeUpdate();
			ps.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha na inser��o do usuario!", "Erro de inser��o", JOptionPane.ERROR_MESSAGE);
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void alterar(Login alteracaoLogin) {
		
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConnectionFactory.getConnection();	

			// Monta a String SQL		
			String sql = "update cadastrousuario set nomeUsuario = ?, " +
					                        "enderecoUsuario = ?, " +
					                        "emailUsuario = ?, " +
					                        "celularUsuario = ?," +
					                        "where idCadastro = ?;";

			
			// Cria um objeto prepareStatement
			ps = con.prepareStatement(sql);	
			
			// Define os valores dos par�metros
			ps.setString(1, alteracaoLogin.getUsuario());				
			ps.setString(2, alteracaoLogin.getEndereco());
			ps.setString(3, alteracaoLogin.getEmail());
			ps.setString(4, alteracaoLogin.getCelular());
			ps.setInt(5, alteracaoLogin.getRegistro());
			
			// Executa a string SQL
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha na altera��o do Usuario!", "Erro de Usuario", JOptionPane.ERROR_MESSAGE);		
		} finally{			
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
	}
	
}
