package main.entity;

public class Ufficio {

	private int id;
	private String nome;

	private int piano;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPiano() {
		return piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

	@Override
	public String toString() {
		return "Ufficio [id=" + id + ", nome=" + nome + ", piano=" + piano + "]";
	}
	

}
