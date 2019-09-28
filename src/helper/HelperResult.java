package helper;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelperResult {
	public static void result(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			RequestDispatcher dispacher = null;
			dispacher = request.getServletContext().getRequestDispatcher("/welcome.jsp");
			try {
				dispacher.forward(request, response);

			} catch (ServletException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}


