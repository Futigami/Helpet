package model;

public class DoencaPet {
	private int registro;
	private String animalDoenca;
	private String racaDoenca;
	private String nomeDoenca;
	private String descricaoDoenca;
	private String sintomaDoenca;
	private String tratamentoDoenca;

	//GET e SET
	
	public String getSintomaDoenca() {
		return sintomaDoenca;
	}
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public String getAnimalDoenca() {
		return animalDoenca;
	}
	public void setAnimalDoenca(String animalDoenca) {
		this.animalDoenca = animalDoenca;
	}
	public String getRacaDoenca() {
		return racaDoenca;
	}
	public void setRacaDoenca(String racaDoenca) {
		this.racaDoenca = racaDoenca;
	}
	public String getNomeDoenca() {
		return nomeDoenca;
	}
	public void setNomeDoenca(String nomeDoenca) {
		this.nomeDoenca = nomeDoenca;
	}
	public void setSintomaDoenca(String sintomaDoenca) {
		this.sintomaDoenca = sintomaDoenca;
	}
	public String getTratamentoDoenca() {
		return tratamentoDoenca;
	}
	public void setTratamentoDoenca(String tratamentoDoenca) {
		this.tratamentoDoenca = tratamentoDoenca;
	}
	public String getDescricaoDoenca() {
		return descricaoDoenca;
	}
	public void setDescricaoDoenca(String descricaoDoenca) {
		this.descricaoDoenca = descricaoDoenca;
	}
	
	
}
