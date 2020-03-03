package model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.AdocaoPet;
import model.DoencaPet;

public class ConsultaDAO {

	public ArrayList<DoencaPet> listarDoenca(String filtro,DoencaPet doencaFiltro){
		Connection con = null;
		String sql = "";
		
		ArrayList<DoencaPet> listarDoenca = new ArrayList<DoencaPet>();
		
		if(filtro.equals("")) {
			sql = "select * from tbdoencafull";
		}
		if(filtro.equals("1")) {
			sql = "select * from tbdoencafull where animalDoenca = '" + doencaFiltro.getAnimalDoenca() + "' and racaDoenca = '" + doencaFiltro.getRacaDoenca() + "' and sintomaDoenca LIKE '%" + doencaFiltro.getSintomaDoenca() + "%'";
		}
		try {
			con = ConnectionFactory.getConnection();
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				DoencaPet doencaUm = new DoencaPet();
				
				doencaUm.setRegistro(rs.getInt("idDoenca"));
				doencaUm.setAnimalDoenca(rs.getString("animalDoenca"));
				doencaUm.setRacaDoenca(rs.getString("racaDoenca"));
				doencaUm.setNomeDoenca(rs.getString("nomeDoenca"));
				doencaUm.setDescricaoDoenca(rs.getString("descricaoDoenca"));
				doencaUm.setSintomaDoenca(rs.getString("sintomaDoenca"));
				doencaUm.setTratamentoDoenca(rs.getString("tratamentoDoenca"));
				
				listarDoenca.add(doencaUm);
				
				doencaUm = null;
			}
			
			stmt.close();
			rs.close();
		}catch (SQLException erro) {  // Captura erros referente a instruções SQL
			erro.printStackTrace();
			
		} catch (Exception erro) { // Captura erros imprevistos
			erro.printStackTrace();
		
		} finally{ // Será executado ocorrendo ou não um erro no bloco try			
			try{
				// Fecha a conexão
				con.close();				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return listarDoenca;
	}

	
}
