package bean;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import connectivity.DatabaseConnection;
import connectivity.NamedParameterStatement;
import object.Regular;
public class RegularBean{
	public static boolean createRegular(Regular regular){
		boolean result = false;
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "insert into regular(name,dob,email,mobileno,reciptno,gender,address,course,user_id) values(:Name, :Dob, :Email, :Mobile, :Recipt, :Gender, :Address, :Course, :User_Id)";
			st =new  NamedParameterStatement(con,quer);
			st.setString("Name",regular.getName());
			st.setString("Dob",regular.getDob());
			st.setString("Email",regular.getEmail());
			st.setString("Mobile",regular.getMobile());
			st.setString("Recipt",regular.getRecipt());
			st.setString("Gender",regular.getGender());
			st.setString("Address",regular.getAddress());
			st.setString("Course",regular.getCourse());
			st.setInt("User_Id",regular.getUser_Id());
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
	public static boolean updateRegular(Regular regular){
		boolean result = false;
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "update regular set name=:Name,dob=:Dob,email=:Email,mobileno=:Mobile,reciptno=:Recipt,gender=:Gender,address=:Address,course=:Course where id=:ID";
			st =new  NamedParameterStatement(con,quer);
			st.setString("Name",regular.getName());
			st.setString("Dob",regular.getDob());
			st.setString("Email",regular.getEmail());
			  st.setString("Mobile",regular.getMobile());
			  st.setString("Recipt",regular.getRecipt());
			  st.setString("Gender",regular.getGender());
			  st.setString("Address",regular.getAddress());
			  st.setString("Course",regular.getCourse());
			  st.setInt("ID",regular.getId());
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

	public static Regular getRegularObjByuserId(int userId){
		NamedParameterStatement st = null;
		Connection con = null;
		ResultSet rs = null;
		Regular rglarObj = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String quer = "select * from regular where User_Id =" + userId + " order by id desc limit 1";
			st =new  NamedParameterStatement(con,quer);
			rs = st.executeQuery();
			if(rs.next()) {
				rglarObj = Regular.createObjFromDataSet(rs);
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
		return rglarObj;
	}

	
}
