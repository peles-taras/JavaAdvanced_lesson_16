package ua.lviv.lgs.dao;

public interface StudentDao{
	public void create(Student student);

	public Student read(int id);

	public Student update(Student student, int id);

	public void delete(int id);
	
	public void delete(String name);
	
	public void readAll();
	
}
