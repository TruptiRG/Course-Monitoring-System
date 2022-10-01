package usecases;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import bean.Admin;
import bean.Batch;
import bean.Course;
import bean.CoursePlan;
import bean.Faculty;
import dao.CourseM_DAO;
import dao.CourseM_DAOImpl;
import exception.AdminException;
import exception.BatchException;
import exception.CourseException;
import exception.CoursePlanException;
import exception.FacultyException;

public class Main {
	
	public static void main(String[] args) {
		System.out.println();
		System.out.println("                                            * WELCOME TO THE COURSE MONITORING SYSTEM *"+"\n");
		System.out.println("Enter : 1 for Admin");
		System.out.println("Enter : 2 for Faculty");
		
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		
		switch(select) {
		
		case 1:
			System.out.println("*     WELCOME     *");
			System.out.println("\n");
			System.out.println("Admin Login :=> ");
			System.out.println("------------------------------------------------------------");
			System.out.println("Enter Admin Username :");
			String username = sc.next();
			System.out.println("Enter Admin Password :");
			String pass = sc.next();
			
			CourseM_DAO cdao = new CourseM_DAOImpl();
			
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(pass);
			
			try {
				admin= cdao.adminLogin(admin);
			
		 		System.out.println("Welcome :"+admin.getUsername());
		 	
		 	
			}catch (AdminException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.println("\n");
			System.out.println("*     WELCOME     *");
			System.out.println("---------------------------------------------------------------");
			System.out.println("\n");
			System.out.println("Chose the given below options to continue :=>");
			System.out.println("Note : Enter number only, mentioned below :");
			System.out.println("================================================");
			System.out.println("Enter 1 to create Faculty :");
			System.out.println("Enter 2 to create Course :");
			System.out.println("Enter 3 to create Batch :");
			System.out.println("Enter 4 to create CoursePlan :");
			System.out.println("Enter 5 to View Course :");
			System.out.println("Enter 6 to View Faculty :");
			System.out.println("Enter 7 to View Batch :");
			System.out.println("Enter 8 to View CoursePlan :");
			System.out.println("Enter 9 to update Faculty :");
			System.out.println("Enter 10 to update Course :");
			System.out.println("Enter 11 to update Batch :");
			System.out.println("Enter 12 to update CoursePlan :");
			System.out.println("Enter 13 to allocate Faculty to batch :");
			System.out.println("Enter 14 to view daywise update to every batch :");
			System.out.println("Enter 15 to generate report of every batch :");
			System.out.println("\n");
			
			sc = new Scanner(System.in);
			int choose =sc.nextInt();
			
			switch(choose) {
			
			case 1:
				
				System.out.println("Enter faculty Id :");
				int id = sc.nextInt();
				System.out.println("Enter faculty Nmame :");
				String facultyName =sc.next();
				System.out.println("Enter faculty Address :");
				String facultyAddress = sc.next();
				System.out.println("Enter mobile :");
				String mobile = sc.next();
				System.out.println("Enter email :");
				String email = sc.next();
				System.out.println("Enter Username :");
				String facultyusername = sc.next();
				System.out.println("Enter Password :");
				String facultypass = sc.next();
				
				Faculty fc = new Faculty();
				fc.setId(id);
				fc.setFacultyName(facultyName);
				fc.setFacultyAddress(facultyAddress);
				fc.setMobile(mobile);
				fc.setEmail(email);
				fc.setUsername(facultyusername);
				fc.setPass(facultypass);
				
				CourseM_DAO dao = new CourseM_DAOImpl();
				String fresult = dao.registerFaculty(fc);
				System.out.println(fresult);
				
			break;
			
			case 2:
				
				System.out.println("Enter course Id :");
				int cId=sc.nextInt();
				System.out.println("Enter course Name :");
				String courseName=sc.next();
				System.out.println("Enter course fee :");
				int fee=sc.nextInt();
				System.out.println("Enter course Description :");
				String descrip=sc.next();
				
				Course c = new Course();
				c.setId(cId);
				c.setCourseName(courseName);
				c.setFee(fee);
				c.setCourseDescription(descrip);
				
				CourseM_DAO cdao1 = new CourseM_DAOImpl();
				String result = cdao1.createCourse(c);
				System.out.println(result);	
			break;
			
			case 3:
				System.out.println("Enter Batch Id :");
				int batchId = sc.nextInt();
				System.out.println("Enter Course Id :");
				int courseId = sc.nextInt();
				System.out.println("Enter Faculty Id :");
				int facultyId = sc.nextInt();
				System.out.println("Enter Number Of Students :");
				int nOfStudents = sc.nextInt();
				System.out.println("Enter the Date at which Batch started :");
				String date = sc.next();
				Date batchStartDate = null;
				try {
					 batchStartDate = (Date) new SimpleDateFormat("dd-mm-yyyy").parse(date);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				System.out.println("Enter duration of Batch :");
				String duration = sc.next();
				
				cdao1 = new CourseM_DAOImpl();
				
				Batch batch = new Batch();
				batch.setBatchId(batchId);
				batch.setCourseId(courseId);
				batch.setFacultyhId(facultyId);
				batch.setNumOfStudents(nOfStudents);
				batch.setBatchStartDate(batchStartDate);
				batch.setDuration(duration);
				
				String result1 = cdao1.createBatch(batch);
				System.out.println(result1);
				
			break;
			
			case 4:
				System.out.println("Enter plan Id :");
				int planId=sc.nextInt();
				System.out.println("Enter Batch Id :");
				int batchId1=sc.nextInt();
				System.out.println("Enter no of Days :");
				int numberOfDays=sc.nextInt();
				System.out.println("Enter the topic :");
				String topic=sc.next();
				System.out.println("Enter Status => 'Completed' or 'Pending' :");
				String ststus=sc.next();
				
				cdao1 = new CourseM_DAOImpl();
				
				CoursePlan coursePlan= new CoursePlan();
				coursePlan.setPlanId(planId);
				coursePlan.setBatchId(batchId1);
				coursePlan.setDayNumber(numberOfDays);
				coursePlan.setTopic(topic);
				coursePlan.setStstus(ststus);
				
				String r = cdao1.createCoursePlan(coursePlan);
				System.out.println(r);
			break;
			
			case 5:
				cdao1 = new CourseM_DAOImpl();
				
				try {
					List<Course> courses = cdao1.viewCourseDetails();
					courses.forEach(co ->{
						System.out.println();
						System.out.println("Course Id : "+co.getId());
						System.out.println("Course Name : "+co.getCourseName());
						System.out.println("Course Fee : "+co.getFee());
						System.out.println("Course Description : "+co.getCourseDescription());
						
						System.out.println("-------------------------------------------------------------");
					});
					
				}catch(CourseException e) {
					System.out.println(e.getMessage());
				}
				
				
			break;
			
			case 6:
				cdao1 = new CourseM_DAOImpl();
				
				try {
					List<Faculty> faculties = cdao1.viewFacultyDetails();
					faculties.forEach(fa ->{
						System.out.println();
						System.out.println("Faculty Id : "+fa.getId());
						System.out.println("Faculty Name : "+fa.getFacultyName());
						System.out.println("Faculty Address : "+fa.getFacultyAddress());
						System.out.println("Faculty mobile : "+fa.getMobile());
						System.out.println("Faculty email : "+fa.getEmail());
						System.out.println("Faculty UserName  "+fa.getUsername());
						System.out.println("Faculty password : "+fa.getPass());
						
						System.out.println("-------------------------------------------------------------------");
					});
					
				}catch(FacultyException e) {
					System.out.println(e.getMessage());
				}
				
				
			break;	
			
			case 7:
				cdao1 = new CourseM_DAOImpl();
				
				try {
					List<Batch> batches = cdao1.viewBatchDetails();
					batches.forEach(ba ->{
						System.out.println();
						System.out.println("Batcj Id : "+ba.getBatchId());
						System.out.println("Course Id : "+ba.getCourseId());
						System.out.println("Faculty Id : "+ba.getFacultyhId());
						System.out.println("Number Of Students : "+ba.getNumOfStudents());
						System.out.println("Batch start Date : "+ba.getBatchStartDate());
						System.out.println("Duration : "+ba.getDuration());
						
						System.out.println("----------------------------------------------------------------------");
					});
				}catch(BatchException e) {
					System.out.println(e.getMessage());
				}
				
				
			break;
			
			case 8:
				cdao1 = new CourseM_DAOImpl();
				
				try {
					List<CoursePlan> cplan = cdao1.viewCoursePlan();
					cplan.forEach(cp ->{
						System.out.println();
						System.out.println("Plan Id : "+cp.getPlanId());
						System.out.println("Batch Id : "+cp.getPlanId());
						System.out.println("Day Number : "+cp.getDayNumber());
						System.out.println("Topic : "+cp.getTopic());
						System.out.println("Status : "+cp.getStstus());
						
						System.out.println("--------------------------------------------------------------------------");
						
					});
					
				}catch(CoursePlanException e) {
					System.out.println(e.getMessage());
				}
				
			break;
			
			case 9:
				
				
			break;	
			
			case 10:
				
				
			break;
			
			case 11:
				
				
			break;
			
			case 12:
				
				
			break;	
			
			case 13:
				System.out.println();
				System.out.println("Enter faculty Id : ");
				int faId = sc.nextInt();
				System.out.println("Enter Course Id : ");
				int coId = sc.nextInt();
				
				cdao1 = new CourseM_DAOImpl();
				try {
					String res = cdao1.allocateFacultytoBatch(coId, faId);
					
					System.out.println(res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			break;
			
			case 14:
				
				System.out.println("Enter course start date ");
				String dat = sc.next();
				Date batchStartDat = null;
				try {
					 batchStartDat = (Date) new SimpleDateFormat("dd-mm-yyyy").parse(dat);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				cdao1 = new CourseM_DAOImpl();
				
				try {
					List<Batch> batches = cdao1.viewBatchDetailsByDate(batchStartDat);
					batches.forEach(ba ->{
						System.out.println();
						System.out.println("Batcj Id : "+ba.getBatchId());
						System.out.println("Course Id : "+ba.getCourseId());
						System.out.println("Faculty Id : "+ba.getFacultyhId());
						System.out.println("Number Of Students : "+ba.getNumOfStudents());
						System.out.println("Batch start Date : "+ba.getBatchStartDate());
						System.out.println("Duration : "+ba.getDuration());
						
						System.out.println("----------------------------------------------------------------------");
					});
				}catch(BatchException e) {
					System.out.println(e.getMessage());
				}
				
				
			break;
			
			case 15:
				
				
				
			break;
				
				
			default:
				System.out.println("Invalid Entry...");
			
			}
			
		break;
		
		case 2:
			System.out.println("*     WELCOME     *");
			System.out.println("Faculty Login :=> ");
			System.out.println("------------------------------------------------------------");
			System.out.println("Enter Faculty Username :");
			String fusername = sc.next();
			System.out.println("Enter Faculty Password :");
			String fpass = sc.next();
			
			cdao = new CourseM_DAOImpl();
			Faculty faculty = new Faculty();
			faculty.setUsername(fusername);
			faculty.setPass(fpass);
			
			try {
				faculty = cdao.facultyLogin(faculty);
				
				System.out.println("Welcome :"+faculty.getUsername());
			}catch (FacultyException e) {
				System.out.println(e.getMessage());
			}
			
			
			System.out.println("\n");
			System.out.println("Enter 1 to view the Course Plan :");
			System.out.println("Enter 2 to to fill up the day wise planner :");
			System.out.println("Enter 3 to update the Password :");
			System.out.println("\n");
			
			sc = new Scanner(System.in);
			int ch =sc.nextInt();
			
			switch(ch) {
			
			case 1:
				cdao = new CourseM_DAOImpl();
				
				try {
					List<CoursePlan> cplan = cdao.viewCoursePlan();
					cplan.forEach(cp ->{
						System.out.println();
						System.out.println("Plan Id : "+cp.getPlanId());
						System.out.println("Batch Id : "+cp.getPlanId());
						System.out.println("Day Number : "+cp.getDayNumber());
						System.out.println("Topic : "+cp.getTopic());
						System.out.println("Status : "+cp.getStstus());
						
						System.out.println("--------------------------------------------------------------------------");
						
					});
					
				}catch(CoursePlanException e) {
					System.out.println(e.getMessage());
				}
			break;
			
			case 2:
				
			break;
			
			case 3:
				
			break;	
			
			}
			
		break;
		
		default:
			System.out.println("Select 1 or 2 only...");
		
		
		
		}
		
		
		
		
	}

}
