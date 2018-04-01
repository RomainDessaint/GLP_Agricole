package infrastructure;
import java.util.ArrayList;

import types.Infrastructure;
import types.Ressource;

public abstract class StorageArea extends Infrastructure {
	private ArrayList<Ressource> stocks;

	public StorageArea(String id, int width, int heigt, ArrayList<Ressource> stocks) {
		super(id, width, heigt);
		this.stocks = stocks;
	}

	public ArrayList<Ressource> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Ressource> stocks) {
		this.stocks = stocks;
	}
	
	public void addRessource(Ressource ressource) {
		stocks.add(ressource);
	}
	
	public void removeRessource(Ressource ressource) {
		stocks.remove(ressource);
	}
}
