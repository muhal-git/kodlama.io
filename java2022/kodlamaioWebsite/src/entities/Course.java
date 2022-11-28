package entities;

public class Course {
	private int id;
	private String picture;
	private String courseName;
	private int price;
	private String progress;
	private int instructorId;
	private int categoryId;
	
	public Course() {
		super();
	}

	public Course(int id, String picture, String courseName, int price, String progress, int instructorId,
			int categoryId) {
		super();
		this.id = id;
		this.picture = picture;
		this.courseName = courseName;
		this.price = price;
		this.progress = progress;
		this.instructorId = instructorId;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
		
}