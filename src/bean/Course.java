package bean;

public class Course {
	
	private int id;
	private String courseName;
	private int fee;
	private String courseDescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public Course(int id, String courseName, int fee, String courseDescription) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.fee = fee;
		this.courseDescription = courseDescription;
	}
	public Course() {
		
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", fee=" + fee + ", courseDescription="
				+ courseDescription + "]";
	}
	
}
