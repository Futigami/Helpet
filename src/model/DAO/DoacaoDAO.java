package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DoacaoPet;

public class DoacaoDAO {

	public void insertDoacao(DoacaoPet doacao) {
		
		Connection con = null;
		PreparedStatement ps = null;

		
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into animaladocao(nomeAnimalAdocao, idadeAnimalAdocao, racaAnimalAdocao, sexoAnimalAdocao, estadoAnimalAdocao, cidadeAnimalAdocao)" +
			"						  values( ?, ?, ?, ?, ?, ?)";

			ps = con.prepareStatement(sql);

			ps.setString(1, doacao.getAnimal());
			ps.setInt(2, doacao.getIdadeAnimal());
			ps.setString(3, doacao.getRacaAnimal());
			ps.setString(4, doacao.getSexoAnimal());
			ps.setString(5, doacao.getEstadoAnimal());
			ps.setString(6, doacao.getCidadeAnimal());
			
			ps.executeQuery();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha na doação!", "Erro de inserção", JOptionPane.ERROR_MESSAGE);
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
