package model.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.AdocaoPet;

public class AdocaoDAO {
	
	AdocaoPet adocaoFiltro;

	public ArrayList<AdocaoPet> listarAdocao(String filtro,AdocaoPet adocaoFiltro){		
		
		Connection con = null;		
		String sql = "";
		
		// Declaração do ArrayList que receberá o retorno do Select
		ArrayList<AdocaoPet> listaAdocao = new ArrayList<AdocaoPet>();
		if(filtro.equals("")) {
			sql = "select * from animaladocao";
		}
		if(filtro.equals("1")){
			sql = "select * from animaladocao where nomeAnimalAdocao = '" + adocaoFiltro.getAnimalAdocao() + "' and estadoAnimalAdocao = '" + adocaoFiltro.getEstadoAdocao() + "' and cidadeAnimalAdocao = '" + adocaoFiltro.getCidadeAdocao() + "'";
		}
			
		try {
			con = ConnectionFactory.getConnection();
			Statement stmt = con.createStatement();
			// Executa o comando SQL
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				// Objeto que receberá cada administrativo (cada linha do ResultSet)
				AdocaoPet umaAdocao = new AdocaoPet();
				// Armazena no objeto umRedPill os dados do ResultSet
				umaAdocao.setRegistro(rs.getInt("idAnimalAdocao"));
				umaAdocao.setAnimalAdocao(rs.getString("nomeAnimalAdocao"));
				umaAdocao.setIdadeAdocao(rs.getString("idadeAnimalAdocao"));
				umaAdocao.setRacaAdocao(rs.getString("racaAnimalAdocao"));
				umaAdocao.setSexoAdocao(rs.getString("sexoAnimalAdocao"));
				umaAdocao.setEstadoAdocao(rs.getString("estadoAnimalAdocao"));
				umaAdocao.setCidadeAdocao(rs.getString("cidadeAnimalAdocao"));
				
				// Armazena o objeto no ArrayList
				listaAdocao.add(umaAdocao);
				// Elimina a referência do objeto para ser reutilizado no próximo registro
				umaAdocao = null;
			}
			stmt.close(); // Finaliza o objeto Statement
			rs.close(); // Fecha o objeto ResultSet
			
		} catch (SQLException erro) { // Trata possiveis erros de SQL 
			erro.printStackTrace();
		} catch (Exception erro) { 
			erro.printStackTrace();
		} finally{ 			
			try{
				con.close(); // Fecha o objeto de conexão				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// Retorna o ArrayList carregado com objetos contento os dados do ResultSet
		return listaAdocao;
	}
	
	public void excluirAdotado(AdocaoPet adocaoExcluir) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = ConnectionFactory.getConnection();
			
			String sql = "delete from animaladocao where idAnimalAdocao = ?;";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, adocaoExcluir.getRegistro());
			ps.executeUpdate();
			ps.close();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha na exclusao!", "Erro de exclusão", JOptionPane.ERROR_MESSAGE); 			
		} finally{			
			try{
				con.close();				
			}catch(Exception e){
				e.printStackTrace();
			}			
		}
		
	}
	
}
