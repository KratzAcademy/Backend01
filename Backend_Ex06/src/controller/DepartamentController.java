package controller;

import java.util.List;
import model.Departament;
import service.DepartamentService;

public class DepartamentController {

    private DepartamentService departamentService;

    public DepartamentController() {
        this.departamentService = new DepartamentService();
    }

    // Método para criar um novo departamento
    public Departament createDepartament(int id, String name) {
        return departamentService.createDepartament(id, name);
    }

    // Método para atualizar os detalhes de um departamento
    public void updateDepartament(Departament departament, String newName) {
        departamentService.updateDepartament(departament, newName);
    }

    // Método para remover um departamento
    public void deleteDepartament(Departament departament) {
        departamentService.deleteDepartament(departament);
    }

    // Método para obter todos os departamentos
    public List<Departament> getAllDepartaments() {
        return departamentService.getAllDepartaments();
    }
}

