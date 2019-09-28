package bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import connectivity.DatabaseConnection;
import connectivity.NamedParameterStatement;
import object.Supplementry;
public class SupplementryBean{
	public static boolean createSupplementry(Supplementry supplementry){
		boolean result = false;
		NamedParameterStatement st = null;
		String quer = "insert into supplementry(name,dob,email,mobileno,registration,sem,address,course,user_id)"
				+ " values(:Name, :Dob, :Email, :Mobile, :Registration, :SupplementrySem, :Address, :Course, :User_Id)";
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			st = new  NamedParameterStatement(con,quer);
			st.setString("Name",supplementry.getName());
			st.setString("Dob",supplementry.getDob());
			st.setString("Email",supplementry.getEmail());
			st.setString("Mobile",supplementry.getMobile());
			st.setString("Registration",supplementry.getRegistration());
			st.setString("SupplementrySem",supplementry.getSupplementrySem());
			st.setString("Address",supplementry.getAddress());
			st.setString("Course",supplementry.getCourse());
			st.setInt("User_Id",supplementry.getUser_Id());
			st.executeUpdate(); 
			result = true;
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
		return result;
	}
	
	public static boolean updateSupplementry(Supplementry supplementry){
		boolean result = false;
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "update supplementry set name=:Name,dob=:Dob,email=:Email,mobileno=:Mobile,registration=:Registration,sem=:SupplementrySem,address=:Address,course=:Course where id=:ID";			
			st = new  NamedParameterStatement(con,quer);
			st.setString("Name",supplementry.getName());
			st.setString("Dob",supplementry.getDob());
			st.setString("Email",supplementry.getEmail());
			st.setString("Mobile",supplementry.getMobile());
			st.setString("Registration",supplementry.getRegistration());
			st.setString("SupplementrySem",supplementry.getSupplementrySem());
			st.setString("Address",supplementry.getAddress());
			st.setString("Course",supplementry.getCourse());
			st.setInt("ID",supplementry.getId());
			st.executeUpdate(); 
			result = true;
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
		return result;
	}

	public static Supplementry getSupplementryObjByuserId(int userId){
		NamedParameterStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		Supplementry suppObj = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "select * from supplementry where User_Id =" + userId + " order by id asc limit 1";
			st =new  NamedParameterStatement(con,quer);
			rs = st.executeQuery();
			if(rs.next()) {
				suppObj = Supplementry.createObjFromDataSet(rs);
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
		return suppObj;
	}

	
	
}
