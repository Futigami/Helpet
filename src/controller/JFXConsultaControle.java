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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DoencaPet;
import model.DAO.ConsultaDAO;

public class JFXConsultaControle implements Initializable{

	@FXML Button bHome_Consulta;
	@FXML Button bPerfil;
	@FXML Button bMeuPet;
	@FXML Button bConsultar;
	@FXML ComboBox cbAnimal;
	@FXML ComboBox cbRaca;
	@FXML ComboBox cbSintoma;
	
	private Stage palcoConsulta;
	
	ConsultaDAO consultaDAO = new ConsultaDAO();

	DoencaPet doenca = new DoencaPet();
	
	private ArrayList<DoencaPet> listarDoenca = new ArrayList<DoencaPet>();
	
	
	public ArrayList<DoencaPet> getListarDoenca() {
		return listarDoenca;
	}
	public void setListarDoenca(ArrayList<DoencaPet> listarDoenca) {
		this.listarDoenca = listarDoenca;
	}

	@FXML TableView<DoencaPet> tvConsulta;
	@FXML TableColumn<DoencaPet, String> tcAnimal;
	@FXML TableColumn<DoencaPet, String> tcRaca;
	@FXML TableColumn<DoencaPet, String> tcDoenca;
	@FXML TableColumn<DoencaPet, String> tcDescricao;
	@FXML TableColumn<DoencaPet, String> tcSintoma;
	@FXML TableColumn<DoencaPet, String> tcTratamento;
	
	public Stage getPalcoConsulta() {
		return palcoConsulta;
	}
	public void setPalcoConsulta(Stage palcoConsulta) {
		this.palcoConsulta = palcoConsulta;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		tcAnimal.setCellValueFactory( new PropertyValueFactory<>("animalDoenca"));
		tcRaca.setCellValueFactory( new PropertyValueFactory<>("racaDoenca"));
		tcDoenca.setCellValueFactory( new PropertyValueFactory<>("nomeDoenca"));
		tcDescricao.setCellValueFactory( new PropertyValueFactory<>("descricaoDoenca"));
		tcSintoma.setCellValueFactory( new PropertyValueFactory<>("sintomaDoenca"));
		tcTratamento.setCellValueFactory( new PropertyValueFactory<>("tratamentoDoenca"));
		
		this.setListarDoenca(consultaDAO.listarDoenca("", null));
		
		tvConsulta.setItems(FXCollections.observableArrayList(this.getListarDoenca()));
		
		cbAnimal.getItems().addAll("Cachorro", "Gato", "Pássaro");
	}
	
	@FXML public void Home() throws IOException
	{
		this.getPalcoConsulta().close();
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
		stage.initOwner(this.getPalcoConsulta());
		
		stage.show();
	}
	@FXML public void MeuPet() 
	{
		
	}
	@FXML public void Consultar() 
	{
		doenca.setAnimalDoenca(String.valueOf(cbAnimal.getSelectionModel().getSelectedItem()));
		doenca.setRacaDoenca(String.valueOf(cbRaca.getSelectionModel().getSelectedItem()));
		doenca.setSintomaDoenca(String.valueOf(cbSintoma.getSelectionModel().getSelectedItem()));

		this.setListarDoenca(consultaDAO.listarDoenca("1", doenca));
	
		atualizaTv();
	}

	@FXML public void carregaListas() {
		
		if(cbAnimal.getSelectionModel().getSelectedItem().equals("Cachorro")) {
			cbRaca.getItems().clear();
			cbSintoma.getItems().clear();
			cbRaca.getItems().addAll("Beagle","Labrador Retrivier","Pastor Alemão","Pug");
			
		}
		if(cbAnimal.getSelectionModel().getSelectedItem().equals("Gato")) {
			cbRaca.getItems().clear();
			cbSintoma.getItems().clear();
			cbRaca.getItems().addAll("American Shorthair","Angorá","Maine Coon", "Siamês");

		}
		if(cbAnimal.getSelectionModel().getSelectedItem().equals("Pássaro")){
			cbRaca.getItems().clear();
			cbSintoma.getItems().clear();
			cbRaca.getItems().addAll("Agapornis","Calopsita","Canário","Papagaio","Periquito");
			
		}

}
	@FXML public void carregarSintomas() 
	{
		//Caso seja Cachorro
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Beagle")) {
			cbSintoma.getItems().addAll("Falta de ar","Cansaço","Tontura e dor no peito, especialmente durante e após esforço físico","Dificuldade de disseminar o local em que o objeto se encontra");
		}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Labrador Retrivier")) {
			cbSintoma.getItems().addAll("Trombar frequentemente em objetos","Clareamento dos olhos","Desequilibrio ou instabilidae");
		}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Pastor Alemão")) {
			cbSintoma.getItems().addAll("Quadros de muita dor");
		}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Pug")) {
			cbSintoma.getItems().addAll("Andando sem coordenação");
		}
		
		//Caso seja Gato
		
		if(cbRaca.getSelectionModel().getSelectedItem().equals("American Shorthair")) {
			cbSintoma.getItems().addAll("Vômitos e diarreias por vezes com sangue", "Salivação excessiva", "Tosse e espirros", "Irritação gástrica", "Irritação da zona da pele que entrou em contato com o tóxico","Dificuldade respiratória", "Convulsões", "Tremores e espasmos musculares involuntários", "Depressão", "Pupilas dilatadas", "Debilidade", "Dificuldade de coordenação nas extremidades", "Perda de consciência","Micção frequente (urinar muitas vezes)");
		}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Angorá")) {
			cbSintoma.getItems().addAll("Anorexia","Perda de peso","Vômito","Diarreia","Dor abdominal");
		}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Maine Coon")) {
			cbSintoma.getItems().addAll("Respiração acelerada","Perda de fôlego em atividades que geralmente não são estressantes", "Dificuldade de respiração","Tosse","Perda de apetite", "Vômitos", "Perda de peso","Desânimo");
		}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Siamês")) {
			cbSintoma.getItems().addAll("Caroços nas glândulas mamárias","Dificuldades respiratórias","Peda de peso","Tonturas","Perdas de equilíbrio", "Vômito", "Queda de pelo", "Dificuldade de posicionamento dos membros","Anorexia");
		}
		
		//Caso seja Pássaro
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Agapornis")) {
			cbSintoma.getItems().addAll("Sonolenta","Abatida","Assustada devido à  inabitação", "Alimentação imprópria");
			}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Calopsita")) {
			cbSintoma.getItems().addAll("Respiração difícil","Ofegante","Imobilidade","Olhos entreabertos","Penas soltas", "Respiração acelerada intermitente com emissão de pequenos gemidos");
			}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Canário")) {
			cbSintoma.getItems().addAll("NDE");
			}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Papagaio")) {
			cbSintoma.getItems().addAll("Asas caídas","Penas soltas" ,"diarreia verde");
			}
		if(cbRaca.getSelectionModel().getSelectedItem().equals("Periquito")) {
			cbSintoma.getItems().addAll("A ave perde o apetite", "Narinas obstruídas", "Bico aberto","Rouquidão e catarro","A ave não canta e fica agitada");
			}
	}
	@FXML public void carregarDados() 
	{
		DoencaPet doencaSelecionada = new DoencaPet();
		
		doencaSelecionada = tvConsulta.getSelectionModel().getSelectedItem();
	}
	
	public void atualizaTv() {
		tvConsulta.setItems(FXCollections.observableArrayList(this.getListarDoenca()));
	}
}
