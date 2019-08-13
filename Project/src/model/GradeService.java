package model;

public interface GradeService {
	boolean insert(Grade grade);

	boolean update(Grade grade);

	boolean delete(String grade);//this history = database history datatype = number type

	String outGrade(int grade_Point);
	
	String outGrade(User user);
}
