package usecases;

import java.util.Scanner;

import bean.Faculty;
import dao.CourseM_DAO;
import dao.CourseM_DAOImpl;

public class RegisterFacultyUsecase {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
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
		String username = sc.next();
		System.out.println("Enter Password :");
		String pass = sc.next();
		
		Faculty fc = new Faculty();
		fc.setId(id);
		fc.setFacultyName(facultyName);
		fc.setFacultyAddress(facultyAddress);
		fc.setMobile(mobile);
		fc.setEmail(email);
		fc.setUsername(username);
		fc.setPass(pass);
		
		CourseM_DAO cdao = new CourseM_DAOImpl();
		String result = cdao.registerFaculty(fc);
		System.out.println(result);
	}

}
