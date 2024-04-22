package model;

public class Student implements Person {
	private String firstName;
	private String lastName;
	private String major;

	public Student() {

	}

	public Student(String firstName, String lastName, String major) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
	}
	
	@Override
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public String getLastName() {
		return lastName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
