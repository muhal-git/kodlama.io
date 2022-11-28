package dataAccess;

import entities.Category;
import entities.Course;
import entities.Instructor;

public class JdbcDao implements CategoryDao,CourseDao,InstructorDao{

	@Override
	public void createInstructor(Instructor inst) {
		System.out.println("JDBC ile egitmen eklendi: " + inst.getName() + " " + inst.getSurname());
	}

	@Override
	public void createCourse(Course course) {
		System.out.println("JDBC ile kurs eklendi: " + course.getCourseName());
	}

	@Override
	public void createCategory(Category category) {
		System.out.println("JDBC ile kategori eklendi: " + category.getCategoryName());
	}
	
}
