package kodlamaioWebsite;

import java.util.ArrayList;
import java.util.List;

import business.CategoryManager;
import business.CourseManager;
import business.InstructorManager;
import dataAccess.CategoryDao;
import dataAccess.CourseDao;
import dataAccess.InstructorDao;
import dataAccess.HibernateDao;
import dataAccess.JdbcDao;
import entities.Category;
import entities.Course;
import entities.Instructor;
import logging.DatabaseLogger;
import logging.FileLogger;
import logging.Logger;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Logger> loggers=new ArrayList<>();
		loggers.add(new DatabaseLogger());
		loggers.add(new FileLogger());
		
		CategoryDao categoryDao = new JdbcDao();
		CategoryManager categoryManager = new CategoryManager(categoryDao, loggers);
		
		categoryManager.addCategory(new Category(1,"Discrete Mathematics"));
		categoryManager.addCategory(new Category(2,"Programming"));
		categoryManager.addCategory(new Category(3,"Data Structures"));
		categoryManager.addCategory(new Category(1,"OS"));
		categoryManager.addCategory(new Category(5,"DBA"));
		categoryManager.addCategory(new Category(1,"Data Structures"));
		categoryManager.addCategory(new Category(7,"OS"));
		
		for (Category kategori : categoryManager.getCategories()) {
			System.out.println(kategori.getId()+" "+kategori.getCategoryName());
		}
		
		InstructorDao instructorDao = new JdbcDao();
		InstructorManager instructorManager = new InstructorManager(instructorDao, loggers);
		instructorManager.addInstructor(new Instructor(1,"AD","SOYAD","Java Develeper"));
		instructorManager.addInstructor(new Instructor(1,"AD","SOYAD","Java Develeper"));
		
		CourseDao courseDao = new HibernateDao();
		CourseManager courseManager = new CourseManager(courseDao,loggers);
		courseManager.addCourse(new Course(1,"ASASAS","Linux",20,"0",1,7));
		courseManager.addCourse(new Course(1,"ASASAS","Linux",-5,"0",1,7));
		
		
	}

}

/*
Kurs ismi tekrar edemez
Kategori ismi tekrar edemez
Bir kursun fiyatı 0 dan küçük olamaz
*/