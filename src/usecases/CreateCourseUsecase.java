package usecases;

import java.util.Scanner;

import bean.Course;
import dao.CourseM_DAO;
import dao.CourseM_DAOImpl;

public class CreateCourseUsecase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
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
		
		CourseM_DAO cdao = new CourseM_DAOImpl();
		String result = cdao.createCourse(c);
		System.out.println(result);
	}

}
