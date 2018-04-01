package ressources;
import types.Ressource;

public class Milk extends Ressource {
	private int quality;
	
	public Milk(int age, int quality, int perishability) {
		super(age, perishability);
		this.quality = quality;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}
}
