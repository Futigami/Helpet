package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JFXMPongsControle {

	@FXML Button bAdocao;
	@FXML Button bConsulta;
	@FXML Button bQuemSomos;
	@FXML Button bContato;
	@FXML Button bLogoff;
	@FXML Button bDoacao;
	@FXML Label lNome;
	
	
	public String getLNome() {
		return lNome.getText();
	}
	public void setLNome(String lNome) {
		this.lNome.setText(lNome);
	}

	
	private Stage palcoOng;
	
	
	public Stage getPalcoOng() {
		return palcoOng;
	}

	public void setPalcoOng(Stage palcoOng) {
		this.palcoOng = palcoOng;
	}

	@FXML public void Adocao() throws IOException
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXAdocao.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXAdocaoControle adocaoControle = loader.getController();
		adocaoControle.setPalcoAdocao(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoOng());
		
		stage.show();
	}
	
	@FXML public void Consulta() throws IOException
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXConsulta.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXConsultaControle consultaControle = loader.getController();
		consultaControle.setPalcoConsulta(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(this.getPalcoOng());
		
		stage.show();
	}
	
	@FXML public void QuemSomos() throws IOException
	{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXQuemSomos.fxml"));
		AnchorPane node = loader.load();
		Scene scene = new Scene(node);
		stage.setScene(scene);
		
		JFXQuemSomosControle somosControle = loader.getController();
		somosControle.setPalcoQuemSomos(stage);
		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.centerOnScreen();
		
		stage.show();
		
		this.getPalcoOng().close();
	}
	
	@FXML public void Contato() 
	{}
	
	@FXML public void Logoff() throws IOException
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
		
		stage.show();
		
		this.getPalcoOng().close();
	}
	
	@FXML public void Doacao() 
	{}

}
