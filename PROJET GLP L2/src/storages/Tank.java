package storages;

import java.util.ArrayList;

import infrastructure.StorageArea;
import types.Ressource;

public class Tank extends StorageArea {

	public Tank(String id, int width, int heigt, ArrayList<Ressource> stocks) {
		super(id, width, heigt, stocks);
	}
}
