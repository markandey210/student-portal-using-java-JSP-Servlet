package connectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import connectivity.NamedParameterStatement;
public class DatabaseConnection {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		String dbDriver = "com.mysql.jdbc.Driver";
		Class.forName(dbDriver);
		String dbURL = "jdbc:mysql://localhost:3306/";
		String dbName = "Students";
		String dbUsername = "root";
		String dbPassword = "mark@1145";
		Connection con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		return con;
	}

	public static void closeConnection(NamedParameterStatement npstmt, Connection conn, ResultSet rs) {
		try {
			rs.close();
			npstmt.close();
			conn.close();
		} catch (Exception e) {
		}
	}

}
