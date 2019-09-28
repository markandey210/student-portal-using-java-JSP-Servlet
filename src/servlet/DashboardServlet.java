package servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import helper.Helper;
import helper.HelperRegular;
import helper.HelperResult;
import helper.HelperSupplementry;
import helper.HelperWelcome;
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispacher = null;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servletPath = request.getServletPath();
		System.out.println("usersssssssssssssssssss  " + servletPath);
		if ("/registration-form".equalsIgnoreCase(servletPath)) {
			Helper.registration(request, response);
		} else if ("/exam-form".equalsIgnoreCase(servletPath)) {
			HelperRegular.regular(request, response);
		} else if ("/backpaper-form".equalsIgnoreCase(servletPath)) {
			HelperSupplementry.supplementry(request, response);
		} else if ("/welcome".equalsIgnoreCase(servletPath)) {
			HelperWelcome.welcome(request, response);
		} else if ("/result".equalsIgnoreCase(servletPath)) {
			HelperResult.result(request, response);
		}}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	}

