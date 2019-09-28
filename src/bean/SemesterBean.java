package bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectivity.DatabaseConnection;
import connectivity.NamedParameterStatement;
import object.Semester;
public class SemesterBean {
	public static boolean createSemester(Semester semester){
		boolean result = false;
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			if(semester!=null) {
				String quer = "insert into semestermarks(sem,persentage, passingyear, user_id) values(:sem, :persentage, :passingyear, :user_id)";
				st = new  NamedParameterStatement(con,quer);
				st.setString("sem", semester.getSemName());
				st.setString("persentage",semester.getPersentage());
				st.setString("passingyear",semester.getPassingYear());
				st.setLong("user_id", semester.getUser_Id());
				st.executeUpdate(); 
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public static boolean updateSemester(Semester semester){
		boolean result = false;
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			if(semester !=null) {
				String quer = "update semestermarks set persentage=:Persentage,passingyear=:PassingYear where id=:ID";
				st = new  NamedParameterStatement(con,quer);
				st.setString("Persentage",semester.getPersentage());
				st.setString("PassingYear",semester.getPassingYear());
				st.setInt("ID",semester.getId());
				st.executeUpdate(); 
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static List<Semester> getSemesterObjByuserId(int userId){
		NamedParameterStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		Semester semObj = null;
		List<Semester> semList = new ArrayList<Semester>();
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "select * from semestermarks where User_Id =" + userId + " order by id asc limit 8";
			st =new  NamedParameterStatement(con,quer);
			rs = st.executeQuery();
			while(rs.next()) {
			 semObj = Semester.createObjFromDataSet(rs);
				if(semObj != null) {
					semList.add(semObj);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return semList;
	}

	public static Semester getSemesterObjBySemId(int semId) {
		NamedParameterStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		Semester semObj = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "select * from semestermarks where id =" + semId;
			st = new NamedParameterStatement(con, quer);
			rs = st.executeQuery();
			if (rs.next()) {
				semObj = Semester.createObjFromDataSet(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return semObj;
	}

}

