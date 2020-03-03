package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JFXHigieneCaesControle {

	@FXML Button bPerfil;
	@FXML Button bMeuPet;
	@FXML Button bVoltar_HigieneCao;
	
	private Stage palcoHigieneCaes;
	
	public Stage getPalcoHigieneCaes() {
		return palcoHigieneCaes;
	}

	public void setPalcoHigieneCaes(Stage palcoHigieneCaes) {
		this.palcoHigieneCaes = palcoHigieneCaes;
	}

	
	@FXML public void Perfil() throws IOException
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXPerfil.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXPerfilControle perfilControle = loader.getController();
		perfilControle.setPalcoPerfil(stage);
		
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoHigieneCaes());
		
		stage.show();
	}
	
	@FXML public void MeuPet() 
	{
		
	}

	@FXML public void Voltar() throws IOException
	{
		this.getPalcoHigieneCaes().close();
	}
	

}
