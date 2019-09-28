package object;

import java.sql.ResultSet;

public class Semester {

	private int id;
	private  String sem;
	private  String percent;
	private  String passingyear;
	private int userid;

	public static Semester createObjFromDataSet(ResultSet rs) {
		Semester user = new Semester();
		try {
			user.setId(rs.getInt("id"));
			user.setSemName(rs.getString("sem"));
			user.setPersentage(rs.getString("persentage"));
			user.setPassingYear(rs.getString("passingyear"));
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
	public String getSemName() {
		return sem;
	}

	public void setSemName(String sem) {
		this.sem = sem;
	}

	public String getPersentage() {
		return percent;
	}

	public void setPersentage(String percent) {
		this.percent = percent;
	}


	public String getPassingYear() {
		return passingyear;
	}

	public void setPassingYear(String passingyear) {
		this.passingyear = passingyear;
	}

	public int getUser_Id() {
		return userid;
	}

	public void setUser_Id(int userid) {
		this.userid = userid;
	}

	
}
