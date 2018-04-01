package datas;



public class DataInfrastructure {
	private static int reservePrice = 3000;
	private static int siloPrice = 2000;
	private static int garagePrice = 3000;
	private static int truckPrice = 2000;
	private static int fieldPrice = 500;
	private static int enclosurePrice = 300;
	
	
	public static int getEnclosurePrice() {
		return enclosurePrice;
	}
	public static void setEnclosurePrice(int enclosurePrice) {
		DataInfrastructure.enclosurePrice = enclosurePrice;
	}
	public static int getFieldPrice() {
		return fieldPrice;
	}
	public static void setFieldPrice(int fieldPrice) {
		DataInfrastructure.fieldPrice = fieldPrice;
	}
	public static int getReservePrice() {
		return reservePrice;
	}
	public static void setReservePrice(int reservePrice) {
		DataInfrastructure.reservePrice = reservePrice;
	}
	public static int getSiloPrice() {
		return siloPrice;
	}
	public static void setSiloPrice(int siloPrice) {
		DataInfrastructure.siloPrice = siloPrice;
	}
	public static int getGaragePrice() {
		return garagePrice;
	}
	public static void setGaragePrice(int garagePrice) {
		DataInfrastructure.garagePrice = garagePrice;
	}
	public static int getTruckPrice() {
		return truckPrice;
	}
	public static void setTruckPrice(int truckPrice) {
		DataInfrastructure.truckPrice = truckPrice;
	}
	
	
}
	
	
