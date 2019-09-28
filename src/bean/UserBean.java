package bean;
import java.sql.ResultSet;
public class UserBean {
		private int id;
		private  String name;
		private  String userName;
		private  String password;
		private  String phone;
		public UserBean() {
		}
		public UserBean(int id, String name, String uName, String contactInfo) {
			this.id = id;
			this.name = name;
			this.phone = contactInfo;
			this.userName = uName;
		}
		public static UserBean createObjFromDataSet(ResultSet rs) {
			UserBean user = new UserBean();
			try {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("Name"));
				user.setPassword(rs.getString("Password"));
				user.setUserName(rs.getString("User_Name"));
				user.setPhone(rs.getString("Contact_No"));
			}catch(Exception e) {
			}
			
			return user;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
	}


