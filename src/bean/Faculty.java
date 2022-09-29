package bean;

public class Faculty {
	
	private int id;
	private String facultyName;
	private String facultyAddress;
	private String mobile;
	private String email;
	private String username;
	private String pass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getFacultyAddress() {
		return facultyAddress;
	}
	public void setFacultyAddress(String facultyAddress) {
		this.facultyAddress = facultyAddress;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Faculty(int id, String facultyName, String facultyAddress, String mobile, String email, String username,
			String pass) {
		super();
		this.id = id;
		this.facultyName = facultyName;
		this.facultyAddress = facultyAddress;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.pass = pass;
	}
	public Faculty() {
		
	}
	@Override
	public String toString() {
		return "Faculty [id=" + id + ", facultyName=" + facultyName + ", facultyAddress=" + facultyAddress + ", mobile="
				+ mobile + ", email=" + email + ", username=" + username + ", pass=" + pass + "]";
	}
	

}
