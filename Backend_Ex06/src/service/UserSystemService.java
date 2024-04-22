package service;

import java.util.ArrayList;
import java.util.List;

import model.Departament;
import model.UserSystem;

public class UserSystemService {

    // Lista em memória para armazenar os usuários
    private List<UserSystem> users;

    public UserSystemService() {
        this.users = new ArrayList<>();
    }

    // Método para criar um novo usuário
    public UserSystem createUser(int id, String name, String email, Departament department) {
        UserSystem newUser = new UserSystem(id, name, email, department);
        users.add(newUser);
        return newUser;
    }

    // Método para atualizar os detalhes de um usuário
    public void updateUser(UserSystem user, String newName, String newEmail, Departament newDepartment) {
        user.setName(newName);
        user.setEmail(newEmail);
        user.setDepartament(newDepartment);
    }

    // Método para remover um usuário
    public void deleteUser(UserSystem user) {
        users.remove(user);
    }

    // Método para obter todos os usuários
    public List<UserSystem> getAllUsers() {
        return users;
    }
}
