package animals;

import datas.DataAnimal;
import types.Animal;

public class Pig extends Animal {
	
	public Pig(String name) {
		super(name);
		this.setQuality(DataAnimal.getPigPerisability());
		this.setQuality(DataAnimal.getChickenQuality());
		this.setWeight(100);
	}
}
