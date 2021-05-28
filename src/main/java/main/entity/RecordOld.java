package main.entity;

import java.util.Date;

public class RecordOld {

	private Integer id;
	private String codiceFiscale;
	private String nome;
	private String cognome;
	private Date dataNascita;
	private Date dataSinistro;

	public int getNumeroSinistri() {
		return numeroSinistri;
	}

	public void setNumeroSinistri(int numeroSinistri) {
		this.numeroSinistri = numeroSinistri;
	}

	private int numeroSinistri;

	private Integer fk_anagrafica;

	public RecordOld() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataSinistro() {
		return dataSinistro;
	}

	public void setDataSinistro(Date dataSinistro) {
		this.dataSinistro = dataSinistro;
	}

	public int getFk_anagrafica() {
		return fk_anagrafica;
	}

	public void setFk_anagrafica(Integer fk_anagrafica) {
		this.fk_anagrafica = fk_anagrafica;
	}

}
