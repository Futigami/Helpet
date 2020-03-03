package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Login;
import model.DAO.UsuarioDAO;

public class JFXPerfilControle implements Initializable{

	private Stage palcoPerfil;
	
	public Stage getPalcoPerfil() {
		return palcoPerfil;
	}

	public void setPalcoPerfil(Stage palcoPerfil) {
		this.palcoPerfil = palcoPerfil;
	}

	UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	Login login = new Login();
	
	@FXML TextField tfUsuario;
	@FXML TextField tfEmail;
	@FXML TextField tfEndereco;
	@FXML TextField tfTelefone;
	@FXML Button bAlterar;
	@FXML Button bVoltar;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.carregarInformacao();
	}
	
	
	@FXML public void Alterar() 
	{
		login.setUsuario(tfUsuario.getText());
		login.setEndereco(tfEndereco.getText());
		login.setEmail(tfEmail.getText());
		login.setCelular(tfTelefone.getText());
		
		usuarioDAO.alterar(login);
	}
	
	@FXML public void Voltar() 
	{
		this.getPalcoPerfil().close();
	}

	public void carregarInformacao(){
		tfUsuario.setText(login.getUsuario());
		tfEndereco.setText(login.getEndereco());
		tfEmail.setText(login.getEmail());
		tfTelefone.setText(login.getCelular());
	}


}
