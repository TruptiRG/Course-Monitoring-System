package dao;

import bean.Course;
import bean.Faculty;

public interface CourseM_DAO {
	
	public String adminconnect(String username, String password);
	
	public String registerFaculty(Faculty fc);
	
	public String createCourse(Course c);
	
	

}
