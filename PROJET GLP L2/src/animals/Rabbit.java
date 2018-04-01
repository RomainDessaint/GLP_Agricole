package animals;
import datas.DataAnimal;
import types.Animal;

public class Rabbit extends Animal {
	
	public Rabbit(String name) {
		super(name);
		this.setQuality(DataAnimal.getRabbitPerisability());
		this.setQuality(DataAnimal.getRabbitQuality());
		this.setWeight(2);
	}
	
}
