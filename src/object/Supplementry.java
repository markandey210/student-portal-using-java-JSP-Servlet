package object;

import java.sql.ResultSet;

public class Supplementry {

	private int id;
	private  String name;
	private  String dob;
	private  String email;
	private  String mobile;
	private String registration;
	private String sem;
	private  String address;
	private  String course;
	private  int userid;

	public static Supplementry createObjFromDataSet(ResultSet rs) {
		Supplementry user = new Supplementry();
		try {
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setDob(rs.getString("dob"));
			user.setEmail(rs.getString("email"));
			user.setMobile(rs.getString("mobileno"));
			user.setRegistration(rs.getString("registration"));
			user.setSupplementrySem(rs.getString("sem"));
			user.setAddress(rs.getString("address"));
			user.setCourse(rs.getString("course"));
			user.setUser_Id(rs.getInt("user_id"));

		}catch(Exception e) {
		}
		
		return user;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getSupplementrySem() {
		return sem;
	}

	public void setSupplementrySem(String sem) {
		this.sem = sem;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getUser_Id() {
		return userid;
	}

	public void setUser_Id(int userid) {
		this.userid = userid;
	}

	
}
