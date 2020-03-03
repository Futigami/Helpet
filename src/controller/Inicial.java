package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DAO.ConnectionFactory;

public class Inicial extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		
		loader.setLocation(getClass().getResource("/view/JFXLogin.fxml"));
		AnchorPane nodeRoot = loader.load();
		Scene scene = new Scene(nodeRoot);
		primaryStage.setScene(scene);
		
		JFXLoginControle loginControle = loader.getController();
		loginControle.setPalcoPrincipal(primaryStage);
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		try {
			
			ConnectionFactory.getConnection();
			
			launch(args);
			
		}catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Falha na conexão com o Banco de Dados!", "ConnectionFactory", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(null, e.getStackTrace().toString(), "Detalhes do erro", JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, e.getStackTrace().toString(), "Erro inesperado", JOptionPane.ERROR_MESSAGE);	
			
		}
	}
}
