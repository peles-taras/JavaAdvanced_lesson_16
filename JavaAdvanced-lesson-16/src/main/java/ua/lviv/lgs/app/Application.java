package ua.lviv.lgs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.lviv.lgs.dao.Student;
import ua.lviv.lgs.dao.StudentDaoImpl;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		StudentDaoImpl studentDao = (StudentDaoImpl) ctx.getBean("studentDaoImpl");
		Student student = (Student) ctx.getBean("student");
		student.setId(1);
		student.setName("test name");
		student.setAge(21);
		
		studentDao.create(student);
		
		studentDao.readAll();     // studentDao.read() -> read single student by student id
		
		Student updatedStudent = (Student) ctx.getBean("updatedStudent");	
		studentDao.update(updatedStudent, 1);      // update student by id
		studentDao.readAll();
		
		System.out.println("--- removing student ---");	
		studentDao.delete("updated name");                // availble option to delete Student by id aswell
		studentDao.readAll();
	}

}
