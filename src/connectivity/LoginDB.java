package connectivity;
import java.sql.*;
import connectivity.DatabaseConnection;
import connectivity.NamedParameterStatement;
import object.User;
public class LoginDB {
	public static User validate(String name, String pass) {
		User user = null;
		NamedParameterStatement npstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = DatabaseConnection.initializeDatabase();
			String sql = "select * from users where User_Name= :USER_NAME and Password= :PASSWORD";
			npstmt = new NamedParameterStatement(conn,sql);
			npstmt.setString("USER_NAME", name);
			npstmt.setString("PASSWORD", pass);
			rs = npstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
									user = User.createObjFromDataSet(rs);
								}
							}
		} catch (Exception e) {
			System.out.println(e);
								} 
		finally {
			DatabaseConnection.closeConnection(npstmt, conn, rs);
					}
		return user;
	}
}
