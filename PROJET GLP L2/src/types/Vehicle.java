package types;

public abstract class Vehicle {
	private String serialNumber;
	private int type;
	
	public Vehicle(String serialNumber, int type) {
		this.serialNumber = serialNumber;
		this.type = type;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
