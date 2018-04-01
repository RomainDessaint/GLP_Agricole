package infrastructure;
import java.util.HashMap;

import types.Infrastructure;
import types.Vehicle;

public class Garage extends Infrastructure {
	private HashMap<String, Vehicle> vehicles;

	public Garage(String id, int width, int heigt, HashMap<String, Vehicle> vehicles) {
		super(id, width, heigt);
		this.vehicles = vehicles;
	}

	public HashMap<String, Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(HashMap<String, Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	public void addVehicle(Vehicle vehicle) {
		vehicles.put(vehicle.getSerialNumber(), vehicle);
	}
	
	public void removeVehicle(Vehicle vehicle) {
		vehicles.remove(vehicle.getSerialNumber());
	}
}