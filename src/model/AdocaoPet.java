package model;

public class AdocaoPet {
	private int registro;
	private String animalAdocao;
	private String racaAdocao;
	private String estadoAdocao;
	private String cidadeAdocao;
	private String idadeAdocao;
	private String sexoAdocao;
	
	//GET e SET
	
	public String getRacaAdocao() {
		return racaAdocao;
	}
	public String getAnimalAdocao() {
		return animalAdocao;
	}
	public void setAnimalAdocao(String animalAdocao) {
		this.animalAdocao = animalAdocao;
	}
	public void setRacaAdocao(String racaAdocao) {
		this.racaAdocao = racaAdocao;
	}
	public String getEstadoAdocao() {
		return estadoAdocao;
	}
	public void setEstadoAdocao(String estadoAdocao) {
		this.estadoAdocao = estadoAdocao;
	}
	public String getCidadeAdocao() {
		return cidadeAdocao;
	}
	public void setCidadeAdocao(String cidadeAdocao) {
		this.cidadeAdocao = cidadeAdocao;
	}
	public String getIdadeAdocao() {
		return idadeAdocao;
	}
	public void setIdadeAdocao(String idadeAdocao) {
		this.idadeAdocao = idadeAdocao;
	}
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public String getSexoAdocao() {
		return sexoAdocao;
	}
	public void setSexoAdocao(String sexoAdocao) {
		this.sexoAdocao = sexoAdocao;
	}
	
	
}
