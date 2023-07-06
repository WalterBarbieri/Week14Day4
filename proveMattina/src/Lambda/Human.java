package Lambda;

public class Human {
	// Lista Proprietà
	String name;
	String surname;
	int age;
	int id;

	// Lista Costruttori
	public Human(String name, String surname, int age, int id) {
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
		this.setId(id);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
