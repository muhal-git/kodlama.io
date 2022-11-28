package business;

import java.util.List;

import dataAccess.InstructorDao;
import entities.Instructor;
import logging.Logger;

public class InstructorManager {
	private InstructorDao instructorDao;
	private List<Logger> loggers;
	private List<Instructor> instructors;
	
	public InstructorManager(InstructorDao instructorDao, List<Logger> loggers/*, List<Instructor> instructors*/) {
		super();
		this.instructorDao = instructorDao;
		this.loggers = loggers;
		//this.instructors = instructors;
	}
	
	public void addInstructor(Instructor instructor) {
		for (Instructor pivot : instructors) {
			if ( pivot.getName() == instructor.getName() && pivot.getSurname() == instructor.getSurname() ) {
				System.out.println("ERROR Egitmen sistemde mevcut.");
				return;
			}
		}
		
		instructors.add(instructor);
		instructorDao.createInstructor(instructor);
		
		for (Logger pivot : loggers) {
			pivot.log();
		}
	}

	public InstructorDao getInstructorDao() {
		return instructorDao;
	}

	public void setInstructorDao(InstructorDao instructorDao) {
		this.instructorDao = instructorDao;
	}

	public List<Logger> getLoggers() {
		return loggers;
	}

	public void setLoggers(List<Logger> loggers) {
		this.loggers = loggers;
	}

	public List<Instructor> getInstructors() {
		return instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}
	
	
}
