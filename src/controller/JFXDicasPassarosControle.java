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

public class JFXDicasPassarosControle {
	
	private Stage palcoDicasPassaro;
	@FXML Button bPerfil;
	@FXML Button bMeuPet;
	@FXML Button bVoltar_DicasPassaros;

	public Stage getPalcoDicasPassaro() {
		return palcoDicasPassaro;
	}

	public void setPalcoDicasPassaro(Stage palcoDicasPassaro) {
		this.palcoDicasPassaro = palcoDicasPassaro;
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
		stage.initOwner(this.getPalcoDicasPassaro());
		
		stage.show();
	}

	@FXML public void MeuPet() {}

	@FXML public void Voltar() throws IOException
	{
		this.getPalcoDicasPassaro().close();
	}
	
	
	
}
