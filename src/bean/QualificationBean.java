package bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectivity.DatabaseConnection;
import connectivity.NamedParameterStatement;
import object.Qualification;
public class QualificationBean {
	public static boolean createQualification(Qualification qualification) {
		boolean result = false;
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			if (qualification != null) {
				String quer = "insert into qualification(class, board, persentage, passingyear, user_id) values(:class, :board, :persentage, :passingyear, :user_id)";
				st = new NamedParameterStatement(con, quer);
				st.setString("class", qualification.getClassName());
				st.setString("board", qualification.getBoard());
				st.setString("persentage", qualification.getPersentage());
				st.setString("passingyear", qualification.getPassingYear());
				st.setLong("user_id", qualification.getUser_Id());
				st.executeUpdate();
				result = true;
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
		return result;
	}

	public static boolean updateQualification(Qualification qualification) {
		boolean result = false;
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			if (qualification != null) {
				String quer = "update qualification set board=:Board,persentage=:Persentage,passingyear=:PassingYear where id=:ID";
				st = new NamedParameterStatement(con, quer);
				st.setString("Board", qualification.getBoard());
				st.setString("Persentage", qualification.getPersentage());
				st.setString("PassingYear", qualification.getPassingYear());
				st.setInt("ID", qualification.getId());
				st.executeUpdate();
				result = true;
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
		return result;
	}

	public static List<Qualification> getQualificationObjByuserId(int userId) {
		NamedParameterStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		Qualification qualiObj = null;
		List<Qualification> qualiList = new ArrayList<Qualification>();
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "select * from qualification where User_Id =" + userId + " order by id asc limit 4";
			st = new NamedParameterStatement(con, quer);
			rs = st.executeQuery();
			while (rs.next()) {
				qualiObj = Qualification.createObjFromDataSet(rs);
				if (qualiObj != null) {
					qualiList.add(qualiObj);
				}
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
		return qualiList;
	}
	public static Qualification getQualificationObjByQuaId(int quaId) {
		NamedParameterStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		Qualification qualiObj = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "select * from qualification where id =" + quaId;
			st = new NamedParameterStatement(con, quer);
			rs = st.executeQuery();
			if (rs.next()) {
				qualiObj = Qualification.createObjFromDataSet(rs);
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
		return qualiObj;
	}

}
