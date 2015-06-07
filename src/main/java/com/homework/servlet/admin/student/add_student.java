package com.homework.servlet.admin.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homework.service.StudentService;

/**
 * Servlet implementation class add_student
 */
public class add_student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public add_student() {
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
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String e_mail = request.getParameter("e_mail");
		String phone = request.getParameter("phone");
		String student_number = request.getParameter("student_number");
		String qq = request.getParameter("qq");
		String dormitory = request.getParameter("dormitory");
		String the_class = request.getParameter("the_class");
		String hashpassword = request.getParameter("hashpassword");
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext(
				"com/homework/properties/spring-context.xml");
		StudentService StudentService = (StudentService) ctx
				.getBean("StudnetService");
		StudentService.add_student(name, age, sex, e_mail, phone, qq,
				dormitory, the_class, hashpassword, student_number);
		response.sendRedirect("Admin/Home.jsp");
		out.flush();
		out.close();
	}

}
