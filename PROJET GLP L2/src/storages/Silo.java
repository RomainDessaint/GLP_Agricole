package storages;
import java.util.ArrayList;

import infrastructure.StorageArea;
import types.Ressource;

public class Silo extends StorageArea {

	public Silo(String id, int width, int heigt, ArrayList<Ressource> stocks) {
		super(id, width, heigt, stocks);
	}
}
