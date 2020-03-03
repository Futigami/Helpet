package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.AdocaoPet;
import model.DAO.AdocaoDAO;



public class JFXAdocaoControle implements Initializable{
	
	//Componentes
	@FXML Button bHome_Adocao;
	@FXML Button bPerfil;
	@FXML Button bMeuPet;
	@FXML RadioButton rbCachorro;
	@FXML RadioButton rbGato;
	@FXML Button bProcurar;
	@FXML ComboBox cbEstado;
	@FXML ComboBox cbCidade;
	@FXML TableColumn<AdocaoPet, String> tcEstado;
	@FXML TableColumn<AdocaoPet, String> tcCidade;
	@FXML TableColumn<AdocaoPet, String> tcAnimal;
	@FXML TableColumn<AdocaoPet, String> tcSexo;
	@FXML TableColumn<AdocaoPet, String> tcRaca;
	@FXML TableColumn<AdocaoPet, String> tcIdade;
	@FXML TableView<AdocaoPet> tvAdocao;
	
	private ArrayList<AdocaoPet> listaAdocao = new ArrayList<AdocaoPet>();
	AdocaoPet adocao = new AdocaoPet();
	AdocaoDAO adocaoDAO = new AdocaoDAO();
	
	//Palco
	private Stage palcoAdocao;
	@FXML ComboBox cbAnimal;
	
	public void setPalcoAdocao(Stage palcoAdocao) {
		this.palcoAdocao = palcoAdocao;
	}

	public Stage getPalcoAdocao() {
		return palcoAdocao;
	}

	public ArrayList<AdocaoPet> getListaAdocao() {
		return listaAdocao;
	}

	public void setListaAdocao(ArrayList<AdocaoPet> listaAdocao) {
		this.listaAdocao = listaAdocao;
	}

	//Eventos dos botões
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		tcAnimal.setCellValueFactory( new PropertyValueFactory<>("animalAdocao"));
		tcRaca.setCellValueFactory( new PropertyValueFactory<>("racaAdocao"));
		tcIdade.setCellValueFactory( new PropertyValueFactory<>("idadeAdocao"));
		tcSexo.setCellValueFactory( new PropertyValueFactory<>("sexoAdocao"));
		tcEstado.setCellValueFactory( new PropertyValueFactory<>("estadoAdocao"));
		tcCidade.setCellValueFactory( new PropertyValueFactory<>("cidadeAdocao"));
		
		this.setListaAdocao(adocaoDAO.listarAdocao("",null));
		
		tvAdocao.setItems(FXCollections.observableArrayList(this.getListaAdocao()));
		
		cbAnimal.getItems().addAll("Cachorro","Gato","Pássaro");
		cbEstado.getItems().addAll("Paraná","São Paulo");
		
	}
	
	@FXML public void Home() throws IOException
	{
		this.getPalcoAdocao().close();
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
		stage.initOwner(this.getPalcoAdocao());
		
		stage.show();
	}
	@FXML public void MeuPet() 
	{
		
	}
	@FXML public void Procurar() throws IOException
	{
		/*
		if(cbAnimal.getSelectionModel().getSelectedItem().toString().equals("") || cbEstado.getSelectionModel().getSelectedItem().toString().equals("") || cbCidade.getSelectionModel().getSelectedItem().toString().equals("")) {
					
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Campos");
			alert.setHeaderText("Campo não utilizado.");
			alert.setContentText("Utilize todos os campos");
			alert.showAndWait();
			
		}else {
		
		*/
		
		adocao.setAnimalAdocao(String.valueOf(cbAnimal.getSelectionModel().getSelectedItem()));
		adocao.setEstadoAdocao(String.valueOf(cbEstado.getSelectionModel().getSelectedItem()));
		adocao.setCidadeAdocao(String.valueOf(cbCidade.getSelectionModel().getSelectedItem()));
		
		this.setListaAdocao(adocaoDAO.listarAdocao("1",adocao));
		
		atualizarTableView();
	}

	@FXML public void carregarDados() 
	{
		AdocaoPet adocaoSelecionado = new AdocaoPet();
		
		adocaoSelecionado = tvAdocao.getSelectionModel().getSelectedItem();
	}

	@FXML public void carregaListas() 
	{
		if(cbEstado.getSelectionModel().getSelectedItem().equals("Paraná")) {
			cbCidade.getItems().clear();
			cbCidade.getItems().addAll("Londrina","Curitiba");
		}
		if(cbEstado.getSelectionModel().getSelectedItem().equals("São Paulo")) {
			cbCidade.getItems().clear();
			cbCidade.getItems().addAll("Hortolândia","Campinas");
		}
		/**if(cbEstado.getSelectionModel().getSelectedItem().equals("Pássaro")){
			cbCidade.getItems().clear();
			cbCidade.getItems().addAll();
		}*/
	}

	@FXML public void Adotar()
	{
				
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Adotar");
		alert.setHeaderText("Validação de adoção.");
		alert.setContentText("Animal adotado com sucesso!");
		alert.showAndWait();
		
		AdocaoPet exclusaoPet = tvAdocao.getSelectionModel().getSelectedItem();
		
		adocaoDAO.excluirAdotado(exclusaoPet);
		
		this.setListaAdocao(adocaoDAO.listarAdocao("",null));
		
		this.atualizarTableView();
		
	}

	public void atualizarTableView() {
		
		tvAdocao.setItems(FXCollections.observableArrayList(this.getListaAdocao()));
	}


}
