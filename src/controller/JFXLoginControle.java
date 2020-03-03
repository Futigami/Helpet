package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Login;
import model.DAO.UsuarioDAO;

public class JFXLoginControle{

	@FXML TextField tfUsuario;
	@FXML PasswordField pfSenha;
	@FXML Button bEntrar;
	@FXML Hyperlink hlEsqueceu;
	@FXML Hyperlink hlCadastrar;
	@FXML Label lSair;

	Login login = new Login();
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	private Stage palcoPrincipal;

	//Getters e Setters

	public Stage getPalcoPrincipal() {
		return palcoPrincipal;
	}

	public void setPalcoPrincipal(Stage palcoPrincipal) {
		this.palcoPrincipal = palcoPrincipal;
	}



	@FXML public void Entrar() throws IOException
	{
			login.setUsuario(tfUsuario.getText());
			login.setSenha(pfSenha.getText());
			
			login = usuarioDAO.autenticar(login);
			
			//Quando logado
			if(login.getRegistro() != 0){

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Login");
				alert.setHeaderText("Validação de usuário comum");
				alert.setContentText("Usuario " + login.getUsuario() + " logado com sucesso!");
				alert.showAndWait();
				
				
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				
				loader.setLocation(getClass().getResource("/view/JFXMenuPrincipal.fxml"));
				AnchorPane node = loader.load();
				Scene scene = new Scene(node);
				stage.setScene(scene);
				
				JFXMenuControle menuControle = loader.getController();
				menuControle.setLNome(login.getUsuario());
				menuControle.setPalcoMenu(stage);
				
				stage.initStyle(StageStyle.UNDECORATED);
				stage.setResizable(false);
				stage.centerOnScreen();
				
				
				stage.show();
				
				tfUsuario.setText("");
				pfSenha.setText("");
				
				this.getPalcoPrincipal().close();
				
			}
			
			else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Login");
				alert.setHeaderText("Validação de usuário");
				alert.setContentText("Usuario ou senha inválido");
				alert.showAndWait();
				
				pfSenha.setText("");
			}

	}

	@FXML public void Cadastrar() throws IOException
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXCadastro.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXCadastroControle cadastroControle = loader.getController();
		cadastroControle.setPalcoCadastro(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		
		stage.show();

		tfUsuario.setText("");
		pfSenha.setText("");
	}

	@FXML public void Sair() 
	{
		System.exit(0);
	}

}
