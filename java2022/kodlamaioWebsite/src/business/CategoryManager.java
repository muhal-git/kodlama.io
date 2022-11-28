package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataAccess.CategoryDao;
import entities.Category;
import logging.Logger;

public class CategoryManager {
	private CategoryDao categoryDao;
	private List<Logger> loggers;
	private ArrayList<Category> categories;

/*	
	public CategoryManager() {
		super();
	}
*/
	public CategoryManager(CategoryDao categoryDao, List<Logger> loggers/*, List<Category> categories*/) {
		super();
		this.categoryDao = categoryDao;
		this.loggers = loggers;
		this.categories = new ArrayList();
	}
	

	
	public void addCategory(Category category) {
		for (Category pivot : categories) {
			if ( category.getCategoryName() == pivot.getCategoryName() ) {
				System.out.println(new Date() + " ERROR Kategori ismi tekrar edemez.");
				return;
			}
			if (category.getId() == pivot.getId() ) {
				System.out.println(new Date() + " ERROR Category ID tekrar edemez.");
				return;
			}
		}
		categories.add(category);
		categoryDao.createCategory(category);
		for (Logger pivot : loggers) {
			pivot.log();
		}
	}
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	public List<Logger> getLoggers() {
		return loggers;
	}
	public void setLoggers(List<Logger> loggers) {
		this.loggers = loggers;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
	
	
	
	
	
}
