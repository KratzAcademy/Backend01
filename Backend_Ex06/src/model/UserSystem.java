package model;

public class UserSystem {
	private int id;
	private String name;
	private String email;
	private Departament departament;

	public UserSystem() {

	}

	public UserSystem(int id, String name, String email, Departament departament) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.departament = departament;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Departament getDepartament() {
		return departament;
	}
	
	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
}
