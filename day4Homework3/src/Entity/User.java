package Entity;


import Abstract.Entity;

public class User implements Entity {
	private int id;
	private String name;
	private String nationalIdentity;
	private String birthYear;

	public User() {
		
	}
	
	public User(int id, String name, String nationalIdentity, String birthYear) {
		this.id = id;
		this.name = name;
		this.nationalIdentity = nationalIdentity;
		this.birthYear = birthYear;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationalIdentity() {
		return nationalIdentity;
	}
	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
}
