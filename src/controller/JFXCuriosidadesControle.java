package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JFXCuriosidadesControle {

	@FXML Button bHome_Curiosidades;
	@FXML Button bPerfil;
	@FXML Button bMeuPet;
	@FXML MenuItem miPCCaes;
	@FXML MenuItem miDicasCaes;
	@FXML MenuItem miHigieneCaes;
	@FXML MenuItem miPCGato;
	@FXML MenuItem miDicaGato;
	@FXML MenuItem miHigieneGato;
	@FXML MenuItem miPCPassaro;
	@FXML MenuItem miDicaPassaro;
	@FXML MenuItem miHigienePassaro;
	
	private Stage palcoCuriosidade = null;

	public Stage getPalcoCuriosidade() {
		return palcoCuriosidade;
	}

	public void setPalcoCuriosidade(Stage palcoCuriosidade) {
		this.palcoCuriosidade = palcoCuriosidade;
	}

	//Caes
	@FXML public void PCCaes() throws IOException
	{
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXPCCaes.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXPCCaesControle pcCaesControle = loader.getController();
		pcCaesControle.setPalcoPCCaes(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();
	}
	@FXML public void DicasCaes() throws IOException
	{
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXDicasCaes.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXDicasCaesControle dicasCaesControle = loader.getController();
		dicasCaesControle.setPalcoDicasCaes(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();
	}
	@FXML public void HigieneCaes() throws IOException
	{
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXHigieneCaes.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXHigieneCaesControle higieneCaesControle = loader.getController();
		higieneCaesControle.setPalcoHigieneCaes(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();
	}

	//Gatos
	@FXML public void PCGato() throws IOException
	{
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXPCGatos.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXPCGatosControle pcGatosControle = loader.getController();
		pcGatosControle.setPalcoPCGato(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();


	}
	@FXML public void DicaGato() throws IOException
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXDicasGatos.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXDicasGatosControle dicasGatosControle = loader.getController();
		dicasGatosControle.setPalcoDicasGato(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();
	}
	@FXML public void HigieneGato() throws IOException
	{
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXHigieneGatos.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXHigieneGatosControle higieneGatosControle = loader.getController();
		higieneGatosControle.setPalcoHigieneGatos(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();

	}

	//Passaro
	@FXML public void PCPassaro() throws IOException
	{
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXPCPassaros.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXPCPassarosControle pcPassarosControle = loader.getController();
		pcPassarosControle.setPalcoPCPassaro(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();

	}
	@FXML public void DicaPassaro() throws IOException
	{
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXDicasPassaros.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXDicasPassarosControle dicasPassarosControle = loader.getController();
		dicasPassarosControle.setPalcoDicasPassaro(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();


	}
	@FXML public void HigienePassaro() throws IOException
	{
		
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXHigienePassaros.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXHigienePassarosControle higienePassarosControle = loader.getController();
		higienePassarosControle.setPalcoHigienePassaro(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoCuriosidade());
		
		
		stage.show();
		

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
		stage.initOwner(this.getPalcoCuriosidade());
		
		stage.show();
	}
	
	@FXML public void MeuPet() 
	{
		
	}
	
	@FXML public void Home() throws IOException
	{

		this.getPalcoCuriosidade().close();
	}



}
