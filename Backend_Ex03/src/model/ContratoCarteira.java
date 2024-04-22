package model;

public class ContratoCarteira extends Funcionario{
	
	private float salarioFixo;
	
	// Construtores
	public ContratoCarteira() {
		super();
	}
	
	public ContratoCarteira(String nome, float salarioFixo) {
		super(nome);
		this.salarioFixo = salarioFixo;
	}

	public float getSalarioFixo() {
		return salarioFixo;
	}

	public void setSalarioFixo(float salarioFixo) {
		this.salarioFixo = salarioFixo;
	}
	
	@Override
	public float calcularSalario() {
		return salarioFixo;
	}
	
}
