package br.edu.devmedia.testes;

public class Pessoa {

	private int id;
	
	private String nome;
	
	private double peso;
	
	private Endereco endereco;

	public Pessoa(int id, String nome, double peso, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.endereco = endereco;
	}

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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
