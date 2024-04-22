package service;

import java.util.ArrayList;
import java.util.List;
import model.Departament;

public class DepartamentService {

    // Lista em memória para armazenar os departamentos
    private List<Departament> departments;

    public DepartamentService() {
        this.departments = new ArrayList<>();
    }

    // Método para criar um novo departamento
    public Departament createDepartament(int id, String name) {
        Departament newDepartament = new Departament(id, name);
        departments.add(newDepartament);
        return newDepartament;
    }

    // Método para atualizar os detalhes de um departamento
    public void updateDepartament(Departament departament, String newName) {
        departament.setName(newName);
    }

    // Método para remover um departamento
    public void deleteDepartament(Departament departament) {
        departments.remove(departament);
    }

    // Método para obter todos os departamentos
    public List<Departament> getAllDepartaments() {
        return departments;
    }
}

