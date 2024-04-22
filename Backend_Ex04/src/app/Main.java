package app;

import model.Professor;
import model.Student;

public class Main {

	public static void main(String[] args) {
		// Criando um professor
		Professor professor = new Professor("Ricardo", "Kratz", 5000.0);
		System.out.println("Professor: " + professor.getFirstName() + " " + professor.getLastName());
		System.out.println("Salary: $" + professor.getSalary());

		// Criando um estudante
		Student student = new Student("Ana", "Maria", "Análise e Desenvolvimento de Sistemas");
		System.out.println("Student: " + student.getFirstName() + " " + student.getLastName());
		System.out.println("Major: " + student.getMajor());
	}

}
