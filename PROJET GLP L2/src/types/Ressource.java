package types;

import ressources.Wheat;

public abstract class Ressource {
	private int age = 0;
	private int perishability = 0;
	private String name;
	private int weight = 0;

	public Ressource(String name) {
		this.name = name;
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
	public String getName() {
		return name;
	}
	public int getWeight() {
		return weight;
	}
}
