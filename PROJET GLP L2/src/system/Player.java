package system;

public class Player {
	boolean principal;
	private String name;
	private String gender;
	private int age;
	
	public Player(boolean principal, String name, String gender, int age) {
		this.principal = principal;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public Player() {
	}
	
	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Player [principal=" + principal + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
}
