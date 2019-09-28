package object;

import java.sql.ResultSet;

public class Qualification {

	private int id;
	private  String clss;
	private  String board;
	private  String percent;
	private  String passingyear;
	private int userid;

	public static Qualification createObjFromDataSet(ResultSet rs) {
		Qualification user = new Qualification();
		try {
			user.setId(rs.getInt("id"));
			user.setClassName(rs.getString("class"));
			user.setBoard(rs.getString("board"));
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
	public String getClassName() {
		return clss;
	}

	public void setClassName(String clss) {
		this.clss = clss;
	}


	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
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
