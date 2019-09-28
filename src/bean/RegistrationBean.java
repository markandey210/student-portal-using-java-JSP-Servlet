package bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import connectivity.DatabaseConnection;
import connectivity.NamedParameterStatement;
import object.Registration;
public class RegistrationBean{
	public static boolean createRegistration(Registration registration){
		boolean result = false;
		NamedParameterStatement st = null;
		String quer = "insert into registration(name,dob,email,mobileno,gender,address,course,user_id) values(:Name, :Dob, :Email, :Mobile, :Gender, :Address, :Course, :User_Id)";
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			st =new  NamedParameterStatement(con,quer);
			st.setString("Name",registration.getName());
			st.setString("Dob",registration.getDob());
			st.setString("Email",registration.getEmail());
			st.setString("Mobile",registration.getMobile());
			st.setString("Gender",registration.getGender());
			st.setString("Address",registration.getAddress());
			st.setString("Course",registration.getCourse());
			st.setInt("User_Id",registration.getUser_Id());
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
	
	public static boolean updateRegistration(Registration registration){
		boolean result = false;
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "update registration set name=:Name,dob=:Dob,email=:Email,mobileno=:Mobile,gender=:Gender,address=:Address,course=:Course where id=:ID";
			st =new  NamedParameterStatement(con,quer);
			st.setString("Name",registration.getName());
			st.setString("Dob",registration.getDob());
			st.setString("Email",registration.getEmail());
			st.setString("Mobile",registration.getMobile());
			st.setString("Gender",registration.getGender());
			st.setString("Address",registration.getAddress());
			st.setString("Course",registration.getCourse());
			st.setInt("ID",registration.getId());
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

	public static Registration getRegistrationObjByuserId(int userId){
		NamedParameterStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		Registration regObj = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "select * from registration where User_Id =" + userId + " order by id asc limit 1";
			st =new  NamedParameterStatement(con,quer);
			rs = st.executeQuery();
			if(rs.next()) {
				regObj = Registration.createObjFromDataSet(rs);
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
		return regObj;
	}
}
