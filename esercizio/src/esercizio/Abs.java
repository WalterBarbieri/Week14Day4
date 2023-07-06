package esercizio;

public abstract class Abs {
	Long id;
	String name;

	public Abs(Long id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public Abs(Long id) {
		this.setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
