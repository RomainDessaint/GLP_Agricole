package animals;
import datas.DataAnimal;
import types.Animal;

public class Sheep extends Animal{


	public Sheep( String name) {
		super(name);
		this.setQuality(DataAnimal.getSheepPerisability());
		this.setQuality(DataAnimal.getSheepQuality());
		this.setWeight(100);
	}

}
