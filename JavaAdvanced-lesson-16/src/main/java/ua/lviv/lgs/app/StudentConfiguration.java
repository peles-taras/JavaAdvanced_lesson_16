package ua.lviv.lgs.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.lviv.lgs.dao.Student;
import ua.lviv.lgs.dao.StudentDao;
import ua.lviv.lgs.dao.StudentDaoImpl;

@Configuration
public class StudentConfiguration {

	@Bean
	StudentDao studentDaoImpl() {
		return new StudentDaoImpl();
	}
	
	@Bean
	Student student() {
		return new Student();
	}
	
	@Bean
	Student updatedStudent() {
		return new Student("updated name", 33);
	}
}
