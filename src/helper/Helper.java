package helper;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.QualificationBean;
import bean.RegistrationBean;
import object.Qualification;
import object.Registration;
import object.User;
public class Helper {
	public static void saveRegistration(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("USER");
		int registrationId = Integer.parseInt(request.getParameter("registration_id"));
		Registration registration = new Registration();
		String name = user.getName();
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String mobileno = user.getPhone();
		String gender = (request.getParameter("gender"));
		String address = request.getParameter("address");
		String course = request.getParameter("course");
		registration.setName(name);
		registration.setDob(dob);
		registration.setEmail(email);
		registration.setMobile(mobileno);
		registration.setGender(gender);
		registration.setAddress(address);
		registration.setCourse(course);
		registration.setUser_Id(user.getId());
		registration.setId(registrationId);
		try {
			boolean isSave = false;
			if (registrationId > 0) {
				isSave = RegistrationBean.updateRegistration(registration);
				request.setAttribute("welcomeMessage", "Registration Form Updated Sucessfully...");
			} else {
				isSave = RegistrationBean.createRegistration(registration);
				request.setAttribute("welcomeMessage", "Registration Form Submitted Sucessfully...");
			}
			if (isSave) {
				saveQualification(request, response);
			}
			System.out.println("save ");
		} catch (Exception e) {
			System.out.println("Not save");
			e.printStackTrace();
		}
	}
	public static void saveQualification(HttpServletRequest request, HttpServletResponse resonse) {
		List<Qualification> qualificationList = new ArrayList<Qualification>();
		User user = (User) request.getSession().getAttribute("USER");
		String qualificationIdStr = request.getParameter("qualification_ids_str") != null
				? (String) request.getParameter("qualification_ids_str")
				: "";
		List<Integer> quaIdList = new ArrayList<Integer>();
		if (qualificationIdStr != null && !"".equals(qualificationIdStr)) {
			String qualiArr[] = qualificationIdStr.split(",");
			if (qualiArr != null && qualiArr.length > 0) {
				for (String quaId : qualiArr) {
					if (quaId != null) {
						quaIdList.add(Integer.parseInt(quaId));
					}
				}
			}
		}
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String paramName = params.nextElement();
			System.out.println("Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
		}
		try {
			boolean isSave = false;
			if (quaIdList != null && quaIdList.size() > 0) {
				for (Integer quaId : quaIdList) {
					Qualification qualificationObj = QualificationBean.getQualificationObjByQuaId(quaId);
					for (int i = 1; i < 5; i++) {
						String clss = request.getParameter("class_" + i);
						if (qualificationObj != null && qualificationObj.getClassName().equalsIgnoreCase(clss)) {
							String board = request.getParameter("board_" + i);
							String percent = request.getParameter("persentage_" + i);
							String passingyear = request.getParameter("passingyear_" + i);
							if (clss != null && !"".equals(clss)) {
								qualificationObj.setBoard(board);
								qualificationObj.setPersentage(percent);
								qualificationObj.setPassingYear(passingyear);
							}
						}
						qualificationList.add(qualificationObj);
						isSave = QualificationBean.updateQualification(qualificationObj);
					}
				}
			} else {
				for (int i = 1; i < 5; i++) {
					Qualification qualification = new Qualification();
					String clss = request.getParameter("class_" + i);
					String board = request.getParameter("board_" + i);
					String percent = request.getParameter("persentage_" + i);
					String passingyear = request.getParameter("passingyear_" + i);
					if (clss != null && clss != "") {
						qualification.setClassName(clss);
						qualification.setBoard(board);
						qualification.setPersentage(percent);
						qualification.setPassingYear(passingyear);
						qualification.setUser_Id(user.getId());
					}
					qualificationList.add(qualification);
					isSave = QualificationBean.createQualification(qualification);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * User Registration when user in logged in
	 **/
	public static void registration(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispacher = null;
		try {
			User user = request.getSession().getAttribute("USER") != null
					? (User) request.getSession().getAttribute("USER")
					: null;
			/**
			 * If User Exist else return index
			 **/
			if (user != null) {
				if ("1".equals(request.getParameter("submit"))) {
					Enumeration<String> params = request.getParameterNames();
					while (params.hasMoreElements()) {
						String paramName = params.nextElement();
						System.out.println(
								"Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
					}
					Helper.saveRegistration(request, response);
					request.setAttribute("USER", user);
					request.setAttribute("REGISTRATION", RegistrationBean.getRegistrationObjByuserId(user.getId()));
					request.setAttribute("QUALIFICATION_LIST",
							QualificationBean.getQualificationObjByuserId(user.getId()));
					dispacher = request.getServletContext().getRequestDispatcher("/registrationform.jsp");
					dispacher.forward(request, response);
				} else {
					request.setAttribute("USER", user);
					request.setAttribute("REGISTRATION", RegistrationBean.getRegistrationObjByuserId(user.getId()));
					request.setAttribute("QUALIFICATION_LIST",
							QualificationBean.getQualificationObjByuserId(user.getId()));
					dispacher = request.getServletContext().getRequestDispatcher("/registrationform.jsp");
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
