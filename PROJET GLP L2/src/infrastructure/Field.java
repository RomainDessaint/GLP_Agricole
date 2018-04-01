package infrastructure;
import java.util.ArrayList;

import types.Infrastructure;
import types.Ressource;

public class Field extends Infrastructure {
	private ArrayList<Ressource> ressources;

	public Field(String id, int width, int heigt, ArrayList<Ressource> ressources) {
		super(id, width, heigt);
		this.ressources = ressources;
	}

	public ArrayList<Ressource> getRessources() {
		return ressources;
	}

	public void setRessources(ArrayList<Ressource> ressources) {
		this.ressources = ressources;
	}
	
	public void addRessource(Ressource ressource) {
		ressources.add(ressource);
	}
	
	public void removeRessource(Ressource ressource) {
		ressources.remove(ressource);
	}
}
