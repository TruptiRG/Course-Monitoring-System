package dao;

import java.sql.Date;
import java.util.List;

import bean.Admin;
import bean.Batch;
import bean.Course;
import bean.CoursePlan;
import bean.Faculty;
import exception.AdminException;
import exception.BatchException;
import exception.CourseException;
import exception.CoursePlanException;
import exception.FacultyException;

public interface CourseM_DAO {
	
	public String adminconnect(String username, String password);
	
	public Admin adminLogin(Admin admin) throws AdminException;
	
	public Faculty facultyLogin(Faculty faculty) throws FacultyException;
	
	public String registerFaculty(Faculty fc);
	
	public String createCourse(Course course);
	
	public String createBatch(Batch batch);
	
	public String createCoursePlan(CoursePlan courseplan);
	
	public List<Course> viewCourseDetails() throws CourseException;
	
	public List<Faculty> viewFacultyDetails() throws FacultyException;
	
	public List<Batch> viewBatchDetails() throws BatchException;
	
	public List<CoursePlan> viewCoursePlan() throws CoursePlanException;
	
	public 	List<Batch> viewBatchDetailsByDate(Date dt) throws BatchException;
	
	public String allocateFacultytoBatch(int fid, int cid) throws FacultyException, CourseException;
	
	
	
}
