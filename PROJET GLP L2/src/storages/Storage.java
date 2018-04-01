package storages;
import java.util.ArrayList;

import infrastructure.StorageArea;
import types.Ressource;

public class Storage extends StorageArea{

	public Storage(String id, int width, int heigt, ArrayList<Ressource> stocks) {
		super(id, width, heigt, stocks);
	}
}
