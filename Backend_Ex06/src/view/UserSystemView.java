package view;

import java.util.Scanner;

public class UserSystemView {

    private Scanner scanner;

    public UserSystemView() {
        this.scanner = new Scanner(System.in);
    }

    // Método para exibir o menu principal
    public int showMainMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Cadastrar usuário");
        System.out.println("2. Atualizar usuário");
        System.out.println("3. Excluir usuário");
        System.out.println("4. Listar usuários");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    // Método para coletar dados para cadastrar um usuário
    public String[] getUserInfo() {
        System.out.print("Digite o nome do usuário: ");
        String name = scanner.next();
        System.out.print("Digite o e-mail do usuário: ");
        String email = scanner.next();
        return new String[]{name, email};
    }

    // Método para coletar o ID do usuário a ser atualizado ou excluído
    public int getUserId() {
        System.out.print("Digite o ID do usuário: ");
        return scanner.nextInt();
    }

    // Método para exibir uma mensagem
    public void showMessage(String message) {
        System.out.println(message);
    }
}
