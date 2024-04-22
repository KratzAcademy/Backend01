package app;

import java.util.ArrayList;
import java.util.Scanner;
import model.ComissionadoTemporario;
import model.ContratoCarteira;
import model.Funcionario;

public class Principal {

    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Cadastrar Comissionado Temporário");
            System.out.println("2. Cadastrar Contrato de Carteira");
            System.out.println("3. Verificar salário de um funcionário");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarComissionadoTemporario(funcionarios, scanner);
                    break;
                case 2:
                    cadastrarContratoCarteira(funcionarios, scanner);
                    break;
                case 3:
                    verificarSalario(funcionarios, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarComissionadoTemporario(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        System.out.println("Cadastro de Comissionado Temporário:");
        System.out.println("Informe o nome do funcionário:");
        String nome = scanner.next();
        System.out.println("Informe o salário fixo do funcionário:");
        float salarioFixo = scanner.nextFloat();
        System.out.println("Informe a comissão do funcionário:");
        float comissao = scanner.nextFloat();

        Funcionario funcionario = new ComissionadoTemporario(nome, salarioFixo, comissao);
        funcionarios.add(funcionario);
        System.out.println("Comissionado Temporário cadastrado com sucesso!");
    }

    private static void cadastrarContratoCarteira(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        System.out.println("Cadastro de Contrato de Carteira:");
        System.out.println("Informe o nome do funcionário:");
        String nome = scanner.next();
        System.out.println("Informe o salário fixo do funcionário:");
        float salarioFixo = scanner.nextFloat();

        Funcionario funcionario = new ContratoCarteira(nome, salarioFixo);
        funcionarios.add(funcionario);
        System.out.println("Contrato de Carteira cadastrado com sucesso!");
    }

    private static void verificarSalario(ArrayList<Funcionario> funcionarios, Scanner scanner) {
        System.out.println("Verificação de salário:");
        System.out.println("Informe o nome do funcionário:");
        String nome = scanner.next();

        boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equals(nome)) {
                System.out.println("Salário de " + nome + ": R$" + funcionario.calcularSalario());
                encontrado = true;
                break;
            }
        }
        1
    }
}

