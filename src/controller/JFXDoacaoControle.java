package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.DoacaoPet;
import model.DAO.DoacaoDAO;
import javafx.scene.control.TableColumn;

public class JFXDoacaoControle implements Initializable{

	DoacaoDAO doacaoDAO = new DoacaoDAO();
	
	@FXML TextField cbAnimal;
	@FXML TextField tfIdade;
	@FXML TextField tfRaca;
	@FXML Button bCadastrar;
	@FXML ComboBox cbSexo;
	@FXML ComboBox cbEstado;
	@FXML ComboBox cbCidade;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cbSexo.getItems().addAll("Masculino", "Feminino");
	}
	
	@FXML public void Cadastrar() 
	{
		DoacaoPet doacaoPet = new DoacaoPet();
		
		doacaoPet.setAnimal(String.valueOf(cbAnimal.getText()));
		doacaoPet.setIdadeAnimal(Integer.parseInt(tfIdade.getText()));
		doacaoPet.setRacaAnimal(tfRaca.getText());
		doacaoPet.setSexoAnimal(String.valueOf(cbSexo.getValue()));
		doacaoPet.setEstadoAnimal(String.valueOf(cbEstado.getValue()));
		doacaoPet.setCidadeAnimal(String.valueOf(cbCidade.getValue()));
		
		doacaoDAO.insertDoacao(doacaoPet);
		
		cbAnimal.setText("");
		tfIdade.setText("");
		tfRaca.setText("");
		cbSexo.setValue("");
		cbEstado.setValue("");
		cbCidade.setValue("");
	}



}
