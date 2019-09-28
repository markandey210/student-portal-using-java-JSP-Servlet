package helper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.RegularBean;
import object.Regular;
import object.User;

public class HelperRegular {
	public static void saveRegular(HttpServletRequest request, HttpServletResponse resonse) {
		User user = (User) request.getSession().getAttribute("USER");
		int regularId = Integer.parseInt(request.getParameter("regular_id"));
		Regular regular = new Regular();
		;
		String name = user.getName();
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String mobileno = user.getPhone();
		String reciptno = (request.getParameter("reciptno"));
		String gender = (request.getParameter("gender"));
		String address = request.getParameter("address");
		String course = request.getParameter("course");
		regular.setName(name);
		regular.setDob(dob);
		regular.setEmail(email);
		regular.setMobile(mobileno);
		regular.setRecipt(reciptno);
		regular.setGender(gender);
		regular.setAddress(address);
		regular.setCourse(course);
		regular.setUser_Id(user.getId());
		regular.setId(regularId);
		try {
			boolean isSave = false;
			if (regularId > 0) {
				isSave = RegularBean.updateRegular(regular);
				request.setAttribute("welcomeMessage", "Regular Form Updated Sucessfully....");

			} else {
				isSave = RegularBean.createRegular(regular);
				request.setAttribute("welcomeMessage", "Regular Form Submitted Sucessfully...");

			}
			if (isSave) {
				request.setAttribute("REGULAR", regular);

			}
			System.out.println("save ");
		} catch (Exception e) {
			System.out.println("Not save");
			e.printStackTrace();
		}
	}

	/**
	 * User Regular when user in logged in
	 **/

	public static void regular(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispacher = null;

		try {
			User user = request.getSession().getAttribute("USER") != null
					? (User) request.getSession().getAttribute("USER")
					: null;

			if (user != null) {
				if ("1".equals(request.getParameter("submit"))) {
					HelperRegular.saveRegular(request, response);
					request.setAttribute("USER", user);
					request.setAttribute("REGULAR", RegularBean.getRegularObjByuserId(user.getId()));
					dispacher = request.getServletContext().getRequestDispatcher("/regularExamform.jsp");
					dispacher.forward(request, response);
				} else {
					request.setAttribute("USER", user);
					request.setAttribute("REGULAR", RegularBean.getRegularObjByuserId(user.getId()));
					dispacher = request.getServletContext().getRequestDispatcher("/regularExamform.jsp");
					dispacher.forward(request, response);
				}
			} else {
				dispacher = request.getServletContext().getRequestDispatcher("/index.jsp");
				dispacher.forward(request, response);
			}

		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
