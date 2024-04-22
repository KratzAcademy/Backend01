package controller;

import java.util.List;
import model.Departament;
import model.UserSystem;
import service.DepartamentService;
import service.UserSystemService;

public class UserSystemController {

    private UserSystemService userService;
    private DepartamentService departamentService;

    public UserSystemController() {
        this.userService = new UserSystemService();
        this.departamentService = new DepartamentService();
    }

    // Método para criar um novo usuário
    public UserSystem createUser(int id, String name, String email, Departament department) {
        return userService.createUser(id, name, email, department);
    }

    // Método para atualizar os detalhes de um usuário
    public void updateUser(UserSystem user, String newName, String newEmail, Departament newDepartment) {
        userService.updateUser(user, newName, newEmail, newDepartment);
    }

    // Método para remover um usuário
    public void deleteUser(UserSystem user) {
        userService.deleteUser(user);
    }

    // Método para obter todos os usuários
    public List<UserSystem> getAllUsers() {
        return userService.getAllUsers();
    }

    // Métodos relacionados aos departamentos
    // Implemente conforme necessário, utilizando o DepartamentService
}

