package view;

import java.util.Scanner;

public class DepartamentView {

    private Scanner scanner;

    public DepartamentView() {
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir o menu de departamento
    public int showDepartamentMenu() {
        System.out.println("\n=== Menu de Departamento ===");
        System.out.println("1. Criar departamento");
        System.out.println("2. Atualizar departamento");
        System.out.println("3. Excluir departamento");
        System.out.println("4. Listar departamentos");
        System.out.println("5. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    // Método para coletar informações para criar um novo departamento
    public String getDepartamentInfo() {
        System.out.print("Digite o nome do departamento: ");
        return scanner.next();
    }

    // Método para coletar o ID do departamento a ser atualizado ou excluído
    public int getDepartamentId() {
        System.out.print("Digite o ID do departamento: ");
        return scanner.nextInt();
    }

    // Método para exibir uma mensagem
    public void showMessage(String message) {
        System.out.println(message);
    }
}
