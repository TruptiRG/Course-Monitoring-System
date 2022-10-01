package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public Admin adminLogin(Admin admin) throws AdminException {
		Admin a=null;
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps= con.prepareStatement("select * from admin where username = ? AND password = ?");
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String username=rs.getString("username");
				String password=rs.getString("password");
				
				a= new Admin(username, password);
			}else {
				throw new AdminException("Invalid Username or password.. ");
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return a;
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
	public Faculty facultyLogin(Faculty faculty) throws FacultyException {
		Faculty faculty1 = null;
		
		try(Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps= con.prepareStatement("select * from faculty where username = ? AND password = ?");
			ps.setString(1, faculty.getUsername());
			ps.setString(2, faculty.getPass());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getNString("password");
				
				faculty1 = new Faculty();
			}else {
				throw new FacultyException("Invalid Username or password.. ");
			}
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return faculty1;
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

	@Override
	public String createBatch(Batch batch) {
		String msg = "Not inserted";
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("insert into batch(batchId,courseId,facultyId,numberOf_Students,batch_startdate,duration) values(?,?,?,?,?,?)");
			ps.setInt(1, batch.getBatchId());
			ps.setInt(2, batch.getCourseId());
			ps.setInt(3, batch.getFacultyhId());
			ps.setInt(4, batch.getNumOfStudents());
			ps.setDate(5, batch.getBatchStartDate());
			ps.setString(6, batch.getDuration());
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg="Batch details added";
			}
			
		}catch(SQLException e) {
			msg=e.getMessage();
		}
		
		return msg;
	}

	@Override
	public String createCoursePlan(CoursePlan courseplan) {
		String msg = "Not inserted";
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("insert into courseplan(planId,batchId,numberOf_Days,topic,ststus) values(?,?,?,?,?)");
			ps.setInt(1, courseplan.getPlanId());
			ps.setInt(2, courseplan.getBatchId());
			ps.setInt(3, courseplan.getDayNumber());
			ps.setString(4, courseplan.getTopic());
			ps.setString(5, courseplan.getStstus());
			
			int x=ps.executeUpdate();
			if(x>0) {
				msg = "Details for coursePlan added";			}
			
		}catch(SQLException e) {
			msg=e.getMessage();
		}
		
		return msg;
	}

	@Override
	public List<Course> viewCourseDetails() throws CourseException {
		List<Course> courses = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()){
			
			PreparedStatement ps =con.prepareStatement("select * from course");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("courseId");
				String n = rs.getString("courseName");
				int fee = rs.getInt("fee");
				String cd = rs.getString("courseDescription");
				
				Course course = new Course(id, n, fee, cd);
				courses.add(course);
			}
			
		}catch(SQLException e) {
			throw new CourseException(e.getMessage());
		}
		
		if(courses.size()==0) {
			throw new CourseException("No course details found..");
		}
		
		return courses;
	}

	@Override
	public List<Faculty> viewFacultyDetails() throws FacultyException {
		List<Faculty> faculties = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("select * from faculty");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("facultyId");
				String fname = rs.getString("facultyName");
				String fa = rs.getString("facultyAddress");
				String m = rs.getString("mobile");
				String e = rs.getString("email");
				String u = rs.getString("username");
				String p = rs.getString("password");
				
				Faculty faculty = new Faculty(fid, fname, fa, m, e, u, p);
				faculties.add(faculty);
			}
			
		}catch(SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		
		if(faculties.size()==0) {
			throw new FacultyException("No Faculty details found..");
		}
		
		return faculties;
	}

	@Override
	public List<Batch> viewBatchDetails() throws BatchException {
		List<Batch> batches = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("select * from batch");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				int bid=rs.getInt("batchId");
				int cid=rs.getInt("courseId");
				int fid=rs.getInt("facultyId");
				int nos=rs.getInt("numberOf_Students");
				java.sql.Date d = rs.getDate("batch_startdate");
				String dur=rs.getString("duration");
				
				Batch batch = new Batch(bid, cid, fid, nos, d, dur);
				batches.add(batch);
			}
		
		}catch(SQLException e) {
			throw new BatchException(e.getMessage());
		}
		
		if(batches.size()==0) {
			throw new BatchException("No Batch details found..");
		}
		
		return batches;
	}

	@Override
	public List<CoursePlan> viewCoursePlan() throws CoursePlanException {
		List<CoursePlan> cplan = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("select * from courseplan");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int pid=rs.getInt("planId");
				int bid=rs.getInt("batchId");
				int dn=rs.getInt("numberOf_Days");
				String t=rs.getString("topic");
				String s=rs.getString("ststus");
				
				CoursePlan courseplan = new CoursePlan(pid, bid, dn, t, s);
				cplan.add(courseplan);
			}
			
		}catch(SQLException e) {
			throw new CoursePlanException(e.getMessage());
		}
		if(cplan.size()==0) {
			throw new CoursePlanException("No details found..");
		}
		
		return cplan;
	}

	@Override
	public String allocateFacultytoBatch(int fid, int cid) throws FacultyException, CourseException {
		String msg = "Not allocated..";
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("select * from faculty where facultyId =?");
			ps.setInt(1, fid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps1 =con.prepareStatement("select * from course where courseId =?");
				ps1.setInt(2, cid);
				ResultSet rs1 = ps1.executeQuery();
				if(rs1.next()) {
					PreparedStatement ps2 =con.prepareStatement("insert into batch(courseId,facultyId) values(?,?)");
					ps2.setInt(1, cid);
					ps2.setInt(2, fid);
					
					int x=ps2.executeUpdate();
					if(x>0) {
						msg="Faculty allocated to batch..";
					}else {
						throw new FacultyException("Technical error.");
					}
				}else {
					throw new CourseException("Invalid.");
				}
				
			}else {
				throw new FacultyException("Invalid Faculty");
			}
			
		}catch(SQLException e) {
			throw new FacultyException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Batch> viewBatchDetailsByDate(Date dt) throws BatchException {
		List<Batch> b = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()){
			PreparedStatement ps =con.prepareStatement("select * from batch where batch_startdate=?");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				int bid=rs.getInt("batchId");
				int cid=rs.getInt("courseId");
				int fid=rs.getInt("facultyId");
				int nos=rs.getInt("numberOf_Students");
				java.sql.Date d = rs.getDate("batch_startdate");
				String dur=rs.getString("duration");
				
				Batch batch = new Batch(bid, cid, fid, nos, d, dur);
				b.add(batch);
			}
			
		}catch(SQLException e) {
			throw new BatchException(e.getMessage());
		}
		
		if(b.size()==0) {
			throw new BatchException("No Batch details found..");
		}
		return b;
	}

	

	

}
