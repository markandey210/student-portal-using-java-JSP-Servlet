package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import helper.HelperUser;
public class UsersServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
  public UsersServlet(){
        super();   }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
    	String servletPath = request.getServletPath();
        if("/login".equalsIgnoreCase(servletPath)){
        	HelperUser.login(request, response);
        }
        else if("/signup".equalsIgnoreCase(servletPath)) {
        	HelperUser.signup(request, response);
        }
        else if("/logout".equalsIgnoreCase(servletPath)) {
        	HelperUser.logout(request, response);
        }
        }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	doPost(request, response);
	}
  }
