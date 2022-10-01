package bean;

import java.sql.Date;

public class Batch {
	
	private int batchId;
	private int courseId;
	private int facultyhId;
	private int numOfStudents;
	private Date batchStartDate;
	private String duration;
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getFacultyhId() {
		return facultyhId;
	}
	public void setFacultyhId(int facultyhId) {
		this.facultyhId = facultyhId;
	}
	public int getNumOfStudents() {
		return numOfStudents;
	}
	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}
	public Date getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(Date batchStartDate) {
		this.batchStartDate = batchStartDate;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Batch() {
		
	}
	public Batch(int batchId, int courseId, int facultyhId, int numOfStudents, Date batchStartDate, String duration) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyhId = facultyhId;
		this.numOfStudents = numOfStudents;
		this.batchStartDate = batchStartDate;
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", courseId=" + courseId + ", facultyhId=" + facultyhId
				+ ", numOfStudents=" + numOfStudents + ", batchStartDate=" + batchStartDate + ", duration=" + duration
				+ "]";
	}
	
	
}
