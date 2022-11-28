package entities;

public class Instructor {
	private int id;
	private String name;
	private String surname;
	private String profile;
	
	public Instructor() {
		super();
	}
	
	public Instructor(int id, String name, String surname, String profile) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.profile = profile;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
