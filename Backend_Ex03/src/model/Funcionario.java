package model;

public class Funcionario {

	private String nome;

	// Construtor Padrão
	public Funcionario() {

	}

	// Construtor Com atribuitos
	public Funcionario(String nome) {
		this.nome = nome;
	}
	// Gets e Sets
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float calcularSalario() {
		return 0;
	}
	
}




