package helper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import connectivity.DatabaseConnection;
import connectivity.LoginDB;
import connectivity.NamedParameterStatement;
import object.User;
public class HelperUser {
	public static void login(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		System.out.println("userName  " + userName);
		System.out.println("password  " + password);
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		try {
			if (userName != null || password != null) {
				User user1 = LoginDB.validate(userName, password);
				if (user1 != null) {
					session.setAttribute("USER", user1);
					session.setMaxInactiveInterval(36000000);
					System.out.println(user1.getUserName());
					response.sendRedirect("/StudentsPortal/welcome");
				} else {
					try {
						request.setAttribute("errorMessage", "Invalid User Id or Password");
						rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					} catch (ServletException e) {
						e.printStackTrace();
					}
				}
			} else {
				rd = request.getRequestDispatcher("/index.jsp");
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void signup(HttpServletRequest request, HttpServletResponse response) {
		NamedParameterStatement st = null;
		Connection con = null;
		try {
			con = DatabaseConnection.initializeDatabase();
			String isPresent = checkUserExistance(request, con);
			RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
			if (isPresent == "true") {
				request.setAttribute("someMessage", "User Already Present");
			} else if (request.getParameter("Name") != null) {
				String quer = "insert into users (Name,Contact_No,User_Name,Password) values(:NAME, :CONTACT, :USER, :PASS)";
				st = new NamedParameterStatement(con, quer);
				String name = request.getParameter("Name");
				String cont = (request.getParameter("Contact_No"));
				String user = request.getParameter("User_Name");
				String pass = request.getParameter("Password");
				st.setString("NAME", name);
				st.setString("CONTACT", cont);
				st.setString("USER", user);
				st.setString("PASS", pass);
				st.executeUpdate();
				if (name != null && !"".equals(name)) {
					request.setAttribute("someMessage", "SIGN UP Sucessfully");
				}
			}
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static String checkUserExistance(HttpServletRequest request, Connection conn) {

		String isPresent = null;
		NamedParameterStatement npstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseConnection.initializeDatabase();
			String sql = "select * from users where User_Name= :USER_NAME or Contact_No= :Contact_No";
			npstmt = new NamedParameterStatement(conn, sql);
			npstmt.setString("USER_NAME", request.getParameter("User_Name"));
			npstmt.setString("Contact_No", request.getParameter("Contact_No"));
			rs = npstmt.executeQuery();
			while (rs.next()) {
				isPresent = "true";
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			DatabaseConnection.closeConnection(npstmt, conn, rs);
		}
		return isPresent;
	}
	public static void logout(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			try {
				request.getRequestDispatcher("/index.jsp").include(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}
			request.getSession().setAttribute("USER", null);
			request.setAttribute("Message1", "Sucessfully LogOut");
			HttpSession session = request.getSession();
			session.invalidate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
