package kodlamaioWebsite;

import java.util.ArrayList;
import java.util.List;

import business.CategoryManager;
import dataAccess.CategoryDao;
import dataAccess.HibernateDao;
import dataAccess.JdbcDao;
import entities.Category;
import logging.DatabaseLogger;
import logging.FileLogger;
import logging.Logger;


public class Main {

	public static void main(String[] args) {
		CategoryDao categoryDao = new JdbcDao();
		ArrayList<Logger> loggers=new ArrayList<>();
		loggers.add(new DatabaseLogger());
		loggers.add(new FileLogger());
		
		CategoryManager categoryManager = new CategoryManager(categoryDao, loggers);
		
		categoryManager.addCategory(new Category(1,"Discrete Mathematics"));
		categoryManager.addCategory(new Category(2,"Programming"));
		categoryManager.addCategory(new Category(3,"Data Structures"));
		categoryManager.addCategory(new Category(1,"OS"));
		categoryManager.addCategory(new Category(5,"DBA"));
		categoryManager.addCategory(new Category(1,"Data Structures"));
		categoryManager.addCategory(new Category(1,"OS"));
		
		for (Category kategori : categoryManager.getCategories()) {
			System.out.println(kategori.getId()+" "+kategori.getCategoryName());
		}
	}

}

/*
Kurs ismi tekrar edemez
Kategori ismi tekrar edemez
Bir kursun fiyatı 0 dan küçük olamaz
*/