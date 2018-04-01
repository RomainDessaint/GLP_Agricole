package infrastructure;
import java.util.HashMap;

import types.Animal;
import types.Infrastructure;

public class Enclosure extends Infrastructure {
	private HashMap<String, Animal> animals;

	public Enclosure(String id, int width, int heigt, HashMap<String, Animal> animals) {
		super(id, width, heigt);
		this.animals = animals;
	}

	public HashMap<String, Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(HashMap<String, Animal> animals) {
		this.animals = animals;
	}
	
	public void addAnimal(Animal animal) { //throws exception
		animals.put(animal.getName(), animal);
	}
	
	public void removeAnimal(Animal animal) {
		animals.remove(animal.getName());
	}
}
