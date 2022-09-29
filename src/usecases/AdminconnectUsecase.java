package usecases;

import java.util.Scanner;

import dao.CourseM_DAO;
import dao.CourseM_DAOImpl;

public class AdminconnectUsecase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username :");
		String username = sc.next();
		System.out.println("Enter Password :");
		String pass = sc.next();
		
		CourseM_DAO cdao = new CourseM_DAOImpl();
		String result = cdao.adminconnect(username, pass);
		System.out.println(result);
	}

}
