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

public class JFXQuemSomosControle {

	@FXML Button bHome_QuemSomos;
	@FXML Button bPerfil;
	@FXML Button bMeuPet;
	
	private Stage palcoQuemSomos;
	
	
	public Stage getPalcoQuemSomos() {
		return palcoQuemSomos;
	}

	public void setPalcoQuemSomos(Stage palcoQuemSomos) {
		this.palcoQuemSomos = palcoQuemSomos;
	}

	@FXML public void Home() throws IOException
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXMenuPrincipal.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXMenuControle menuControle = loader.getController();
		menuControle.setPalcoMenu(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		
		stage.show();
		
		this.getPalcoQuemSomos().close();
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
		stage.initOwner(this.getPalcoQuemSomos());
		
		stage.show();
	}
	
	@FXML public void MeuPet() 
	{}
	

}
