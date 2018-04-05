package types;

public abstract class Animal {
	
	private boolean live = true;
	private String name;
	private int quality;
	private int perishability;
	private int age = 0;
	private int weight;
	
	public Animal() {
	}

	public Animal(String name) {
		this.name = name;
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getPerishability() {
		return perishability;
	}

	public void setPerishability(int perishability) {
		this.perishability = perishability;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void incrementAge() {
		age++;
	}
	
	public void incrementWeigh() {
		weight++;
	}
	
	public void AnimalDeath() {
		live = false;
	}
	
	public void decrementPerisability() {
		perishability--;
	}
	
}
