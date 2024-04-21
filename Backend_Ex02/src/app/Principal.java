package app;

import model.Funcionario;

public class Principal {

	public static void main(String[] args) {
			Funcionario funcionario = new Funcionario("João", 30, 2500.0);
			System.out.println("Nome: "+ funcionario.getNome());
			System.out.println("Idade: "+ funcionario.getIdade());
			System.out.println("Salario: "+ funcionario.getSalario());
	}

}
