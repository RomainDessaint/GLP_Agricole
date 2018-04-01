package types;

public abstract class Ressource {
	private int age;
	private int perishability;

	public Ressource(int age, int perishability) {
		this.age = age;
		this.perishability = perishability;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPerishability() {
		return perishability;
	}

	public void setPerishability(int perishability) {
		this.perishability = perishability;
	}
}
