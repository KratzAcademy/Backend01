package app;

import controller.DepartamentController;
import controller.UserSystemController;
import model.Departament;
import model.UserSystem;
import view.DepartamentView;
import view.UserSystemView;

public class Main {

    public static void main(String[] args) {
        UserSystemView userView = new UserSystemView();
        DepartamentView departamentView = new DepartamentView();
        UserSystemController userController = new UserSystemController();
        DepartamentController departamentController = new DepartamentController();

        // Exemplo de uso do UserSystemController e UserSystemView
        int option;
        do {
            option = userView.showMainMenu();
            switch (option) {
                case 1:
                    String[] userInfo = userView.getUserInfo();
                    UserSystem newUser = userController.createUser(0, userInfo[0], userInfo[1], null);
                    userView.showMessage("Usuário criado: " + newUser.getName() + " - " + newUser.getEmail());
                    break;
                // Outras opções do menu principal
                // ...
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);

        // Exemplo de uso do DepartamentController e DepartamentView
        option = departamentView.showDepartamentMenu();
        switch (option) {
            case 1:
                String departamentName = departamentView.getDepartamentInfo();
                Departament newDepartament = departamentController.createDepartament(0, departamentName);
                departamentView.showMessage("Departamento criado: " + newDepartament.getName());
                break;
            // Outras opções do menu de departamento
            // ...
            default:
                System.out.println("Opção inválida!");
        }
    }
}
