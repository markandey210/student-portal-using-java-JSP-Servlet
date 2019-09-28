package helper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelperWelcome {
	public static void welcome(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			RequestDispatcher dispacher = null;
			dispacher = request.getServletContext().getRequestDispatcher("/welcome.jsp");
			try {
				dispacher.forward(request, response);
				PrintWriter out = response.getWriter();
				String n = request.getParameter("User_Name");
				out.print("Welcome " + n);
				out.close();

			} catch (ServletException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}


}}
