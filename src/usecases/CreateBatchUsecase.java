package usecases;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import bean.Batch;
import dao.CourseM_DAO;
import dao.CourseM_DAOImpl;

public class CreateBatchUsecase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
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
		
		CourseM_DAO cdao = new CourseM_DAOImpl();
		
		Batch batch = new Batch();
		batch.setBatchId(batchId);
		batch.setCourseId(courseId);
		batch.setFacultyhId(facultyId);
		batch.setNumOfStudents(nOfStudents);
		batch.setBatchStartDate(batchStartDate);
		batch.setDuration(duration);
		
		String result = cdao.createBatch(batch);
		System.out.println(result);
		
	}

}
