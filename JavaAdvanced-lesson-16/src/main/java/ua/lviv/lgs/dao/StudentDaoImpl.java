package ua.lviv.lgs.dao;

import java.util.Iterator;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void create(Student student) {
		Student.students.add(student);
	}

	@Override
	public Student read(int id) {
		Iterator<Student> iterator = Student.students.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	@Override
	public Student update(Student student, int id) {
		Student updatedStudent = read(id);
		updatedStudent.setName(student.getName());
		updatedStudent.setAge(student.getAge());

		return updatedStudent;
	}

	@Override
	public void delete(int id) {
		Student.students.remove(read(id));

	}

	@Override
	public void delete(String name) {
		Iterator<Student> iterator = Student.students.iterator();
		while (iterator.hasNext()) {
			Student student = (Student) iterator.next();
			if (student.getName().equals(name)) {
				iterator.remove();
			}
		}
	}

	public void readAll() {
		for (Iterator<Student> iterator = Student.students.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student);
		}
		if (Student.students.size() == 0) {
			System.out.println("Students list is empty");
		}
	}

}
