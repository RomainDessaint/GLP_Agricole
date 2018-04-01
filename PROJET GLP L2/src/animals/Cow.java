package animals;
import datas.DataAnimal;
import types.Animal;

public class Cow extends Animal {
	
	public Cow(String name) {
		super(name);
		this.setQuality(DataAnimal.getCowPerisability());
		this.setQuality(DataAnimal.getCowQuality());
		this.setWeight(750);
	}
}
