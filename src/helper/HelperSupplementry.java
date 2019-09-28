package helper;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.SupplementryBean;
import bean.SemesterBean;
import object.Semester;
import object.Supplementry;
import object.User;

public class HelperSupplementry {
	public static void saveSupplementry(HttpServletRequest request, HttpServletResponse resonse) {
		User user = (User) request.getSession().getAttribute("USER");
		int supplementryId = Integer.parseInt(request.getParameter("supplementry_id"));
		Supplementry supplementry = new Supplementry();
		String name = user.getName();
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		String mobileno = user.getPhone();
		String address = request.getParameter("address");
		String course = request.getParameter("course");
		String sem = request.getParameter("sem");
		String registration = request.getParameter("registration");
		supplementry.setName(name);
		supplementry.setDob(dob);
		supplementry.setEmail(email);
		supplementry.setMobile(mobileno);
		supplementry.setAddress(address);
		supplementry.setCourse(course);
		supplementry.setSupplementrySem(sem);
		supplementry.setRegistration(registration);
		supplementry.setUser_Id(user.getId());
		supplementry.setId(supplementryId);

		try {
			boolean isSave = false;
			if (supplementryId > 0) {
				isSave = SupplementryBean.updateSupplementry(supplementry);
				request.setAttribute("welcomeMessage", "Supplementry Form Updated Sucessfully...");

			} else {
				isSave = SupplementryBean.createSupplementry(supplementry);
				request.setAttribute("welcomeMessage", "Supplementry Form Submitted Sucessfully....");

			}
			if (isSave) {
				saveSemester(request, resonse);
				request.setAttribute("SUPPLEMENTRY", supplementry);
			}
			System.out.println("save ");
		} catch (Exception e) {
			System.out.println("Not save");
			e.printStackTrace();
		}
	}

	public static void saveSemester(HttpServletRequest request, HttpServletResponse resonse) {
		List<Semester> semesterList = new ArrayList<Semester>();
		User user = (User) request.getSession().getAttribute("USER");
		String semesterIdStr = request.getParameter("semester_ids_str") != null
				? (String) request.getParameter("semester_ids_str")
				: "";
		List<Integer> semIdList = new ArrayList<Integer>();
		if (semesterIdStr != null && !"".equals(semesterIdStr)) {
			String semArr[] = semesterIdStr.split(",");
			if (semArr != null && semArr.length > 0) {
				for (String semId : semArr) {
					if (semId != null) {
						semIdList.add(Integer.parseInt(semId));
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
			if (semIdList != null && semIdList.size() > 0) {
				for (Integer semId : semIdList) {
					Semester semesterObj = SemesterBean.getSemesterObjBySemId(semId);
					for (int i = 1; i < 9; i++) {
						String sem = request.getParameter("sem_" + i);
						if (semesterObj != null && semesterObj.getSemName().equalsIgnoreCase(sem)) {
							String percent = request.getParameter("persentage_" + i);
							String passingyear = request.getParameter("passingyear_" + i);
							if (sem != null && !"".equals(sem)) {
								semesterObj.setPersentage(percent);
								semesterObj.setPassingYear(passingyear);
							}
						}
						semesterList.add(semesterObj);
						isSave = SemesterBean.updateSemester(semesterObj);
					}
				}
			} else {
				for (int i = 1; i < 9; i++) {
					Semester semester = new Semester();
					String sem = request.getParameter("sem_" + i);
					String percent = request.getParameter("persentage_" + i);
					String passingyear = request.getParameter("passingyear_" + i);
					if (sem != null && sem != "") {
						semester.setSemName(sem);
						semester.setPersentage(percent);
						semester.setPassingYear(passingyear);
						semester.setUser_Id(user.getId());
					}
					semesterList.add(semester);
					isSave = SemesterBean.createSemester(semester);
				}
			}
			if (semesterList != null && semesterList.size() > 0) {
				if (isSave) {
					request.setAttribute("SEMESTER_LIST", semesterList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * User Supplementry when user in logged in
	 **/

	public static void supplementry(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispacher = null;
		try {
			User user = request.getSession().getAttribute("USER") != null
					? (User) request.getSession().getAttribute("USER")
					: null;
			if (user != null) {
				if ("1".equals(request.getParameter("submit"))) {
					Enumeration<String> params = request.getParameterNames();
					while (params.hasMoreElements()) {
						String paramName = params.nextElement();
						System.out.println(
								"Parameter Name - " + paramName + ", Value - " + request.getParameter(paramName));
					}
					HelperSupplementry.saveSupplementry(request, response);
					request.setAttribute("USER", user);
					request.setAttribute("SUPPLEMENTRY", SupplementryBean.getSupplementryObjByuserId(user.getId()));
					request.setAttribute("SEMESTER_LIST", SemesterBean.getSemesterObjByuserId(user.getId()));
					dispacher = request.getServletContext().getRequestDispatcher("/supplementryform.jsp");
					dispacher.forward(request, response);
				} else {
					request.setAttribute("USER", user);
					request.setAttribute("SUPPLEMENTRY", SupplementryBean.getSupplementryObjByuserId(user.getId()));
					request.setAttribute("SEMESTER_LIST", SemesterBean.getSemesterObjByuserId(user.getId()));
					dispacher = request.getServletContext().getRequestDispatcher("/supplementryform.jsp");
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
