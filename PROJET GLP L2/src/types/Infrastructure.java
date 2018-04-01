package types;

public abstract class Infrastructure {
	private String id;
	private int width;
	private int heigt;
	
	public Infrastructure(String id, int width, int heigt) {
		this.id = id;
		this.width = width;
		this.heigt = heigt;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeigt() {
		return heigt;
	}
	
	public void setHeigt(int heigt) {
		this.heigt = heigt;
	}
}
