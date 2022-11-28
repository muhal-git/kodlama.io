package business;

import java.util.List;

import dataAccess.CourseDao;
import entities.Course;
import logging.Logger;

public class CourseManager {
	private CourseDao courseDao;
	private List<Logger> loggers;
	private List<Course> courses;
//	public CourseManager() {
//		super();
//	}
	public CourseManager(CourseDao courseDao, List<Logger> loggers/*, List<Course> courses*/) {
		super();
		this.courseDao = courseDao;
		this.loggers = loggers;
		//this.courses = courses;
	}
	
	public void addCourse(Course course) {
		for (Course pivot : courses) {
			if ( pivot.getCourseName() == course.getCourseName() ) {
				System.out.println("Kurs ismi tekrar edemez.");
				return;
			} 
		}
		
		courses.add(course);
		courseDao.createCourse(course);
		
		for (Logger pivot : loggers) {
			pivot.log();
		}
	}
	public CourseDao getCourseDao() {
		return courseDao;
	}
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	public List<Logger> getLoggers() {
		return loggers;
	}
	public void setLoggers(List<Logger> loggers) {
		this.loggers = loggers;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	
}
	

