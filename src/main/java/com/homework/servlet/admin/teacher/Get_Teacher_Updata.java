package com.homework.servlet.admin.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homework.service.StudentService;
import com.homework.service.TeacherService;

/**
 * Servlet implementation class Get_Teacher_Updata
 */
public class Get_Teacher_Updata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Get_Teacher_Updata() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request == null) {
			return;
		}
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String e_mail = request.getParameter("e_mail");
		String phone = request.getParameter("phone");
		String login_user = request.getParameter("login_user");
		String qq = request.getParameter("qq");
		String office = request.getParameter("office");
		String hashpassword = request.getParameter("hashpassword");
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext(
				"com/homework/properties/spring-context.xml");
		TeacherService TeacherService = (TeacherService) ctx
				.getBean("TeacherService");
		TeacherService.updata_teacher(Integer.parseInt(id), name, sex, age,
				e_mail, phone, office, qq, login_user, hashpassword);
		response.sendRedirect("Admin/Home.jsp");
		out.flush();
		out.close();

	}

}
