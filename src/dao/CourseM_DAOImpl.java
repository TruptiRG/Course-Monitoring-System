package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.Course;
import bean.Faculty;
import utility.DBUtil;

public class CourseM_DAOImpl implements CourseM_DAO{

	@Override
	public String adminconnect(String username, String password) {
		String msg="Not inserted";
		
		try(Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps =con.prepareStatement("insert into admin(username,password) values(?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Username and Password set for Admin";
			}
			
		}catch(SQLException e){
			msg=e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String registerFaculty(Faculty fc) {
		String msg = "Data not inserted";
		
			try(Connection con = DBUtil.provideConnection()){
					
					PreparedStatement ps =con.prepareStatement("insert into faculty(facultyId,facultyName,facultyAddress,mobile,email,username,password) values(?,?,?,?,?,?,?)");
					ps.setInt(1, fc.getId());
					ps.setString(2, fc.getFacultyName());
					ps.setString(3, fc.getFacultyAddress());
					ps.setString(4, fc.getMobile());
					ps.setString(5, fc.getEmail());
					ps.setString(6, fc.getUsername());
					ps.setString(7, fc.getPass());
					
					int x=ps.executeUpdate();
					if(x>0) {
						msg="Faculty registered Sucessfully";
					}
					
			}catch(SQLException e){
					msg=e.getMessage();
			}
		
		return msg;
	}

	@Override
	public String createCourse(Course c) {
		String msg = "Not inserted";
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("insert into course(courseId,courseNmae,fee,courseDescription) values(?,?,?,?)");			
			ps.setInt(1, c.getId());
			ps.setString(2,c.getCourseName());
			ps.setInt(3, c.getFee());
			ps.setNString(4, c.getCourseDescription());
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Course details added";
			}
			
		}catch(SQLException e) {
			msg=e.getMessage();
		}
		
		return msg;
	}

}
