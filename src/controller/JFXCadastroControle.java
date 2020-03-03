package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Login;
import model.DAO.UsuarioDAO;

public class JFXCadastroControle {

	Login login = new Login();
	
	UsuarioDAO userDAO = new UsuarioDAO();
	
	private Stage palcoCadastro;
	
	
	public void setPalcoCadastro(Stage palcoCadastro) {
		this.palcoCadastro = palcoCadastro;
	}

	public Stage getPalcoCadastro() {
		return palcoCadastro;
	}
	
	@FXML TextField tfUsuario;
	@FXML TextField tfEmail;
	@FXML TextField tfEndereco;
	@FXML TextField tfTelefone;
	@FXML PasswordField pfSenha;
	@FXML PasswordField pfConfirmaSenha;
	@FXML Button bCadastrar;
	@FXML Button bVoltar;
	
	@FXML public void Cadastrar()
	{
		if(tfUsuario.getText() != "" || tfEmail.getText() != "" || tfEndereco.getText() != "" || tfTelefone.getText() != "") {
			if(pfSenha.getText().equals(pfConfirmaSenha.getText()) && pfSenha.getText() != ""){
				
				login.setUsuario(tfUsuario.getText());
				login.setSenha(pfSenha.getText());
				login.setEndereco(tfEndereco.getText());
				login.setEmail(tfEmail.getText());
				login.setCelular(tfTelefone.getText());
				
				userDAO.inserir(login);
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Cadastro");
				alert.setHeaderText("Validação de formulário de cadastro");
				alert.setContentText("Usuário cadastrado com sucesso");
				alert.showAndWait();
				
				tfUsuario.setText("");
				pfSenha.setText("");
				pfConfirmaSenha.setText("");
				tfEndereco.setText("");
				tfEmail.setText("");
				tfTelefone.setText("");
				
			}
			else {
				
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Cadastro");
				alert.setHeaderText("Validação de formulário de cadastro");
				alert.setContentText("A senha não coincide com a confirmação ou o campo senha está vazio!");
				alert.showAndWait();
				
				
				pfSenha.setText("");
				pfConfirmaSenha.setText("");
			}

		}
		else 
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Cadastro");
			alert.setHeaderText("Validação de formulário de cadastro");
			alert.setContentText("Os campos não podem estar vazios!");
			alert.showAndWait();
		}
	}
	
	@FXML public void Voltar() throws IOException
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXLogin.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXLoginControle loginControle = loader.getController();
		loginControle.setPalcoPrincipal(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initOwner(this.getPalcoCadastro());
		
		stage.show();
		
		this.getPalcoCadastro().close();
		
	}

}
