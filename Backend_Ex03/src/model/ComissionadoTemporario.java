package model;

public class ComissionadoTemporario extends Funcionario {
	private float salarioFixo;
	private float comissao;
	
	// Construtores
	public ComissionadoTemporario() {
		super();
	}
	
	public ComissionadoTemporario(String nome, float salarioFixo, float comissao) {
		super(nome);
		this.salarioFixo = salarioFixo;
		this.comissao = comissao;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	public float getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(float salarioFixo) {
		this.salarioFixo = salarioFixo;
	}
	
	@Override
	public float calcularSalario() {
		return salarioFixo + comissao;
	}
}
