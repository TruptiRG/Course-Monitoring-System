package usecases;

import java.util.Scanner;

import bean.CoursePlan;
import dao.CourseM_DAO;
import dao.CourseM_DAOImpl;

public class CreateCoursePlanUsecase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter plan Id :");
		int planId=sc.nextInt();
		System.out.println("Enter Batch Id :");
		int batchId=sc.nextInt();
		System.out.println("Enter no of Days :");
		int numberOfDays=sc.nextInt();
		System.out.println("Enter the topic :");
		String topic=sc.next();
		System.out.println("Enter Status => 'Completed' or 'Pending' :");
		String ststus=sc.next();
		
		CourseM_DAO cdao = new CourseM_DAOImpl();
		
		CoursePlan coursePlan= new CoursePlan();
		coursePlan.setPlanId(planId);
		coursePlan.setBatchId(batchId);
		coursePlan.setDayNumber(numberOfDays);
		coursePlan.setTopic(topic);
		coursePlan.setStstus(ststus);
		
		String result = cdao.createCoursePlan(coursePlan);
		System.out.println(result);
	}

}
