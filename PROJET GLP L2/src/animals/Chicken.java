package animals;
import datas.DataAnimal;
import types.Animal;

public class Chicken extends Animal {
	
	public Chicken(String name) {
		super(name);
		this.setQuality(DataAnimal.getChickenPerisability());
		this.setQuality(DataAnimal.getChickenQuality());
		this.setWeight(3);
	}
}
