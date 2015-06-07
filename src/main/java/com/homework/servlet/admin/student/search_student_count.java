package com.homework.servlet.admin.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homework.service.StudentService;

/**
 * Servlet implementation class search_student_count
 */
public class search_student_count extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public search_student_count() {
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
		if (request == null) {
			return;
		}
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String page_m = request.getParameter("page_m");
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext(
				"com/homework/properties/spring-context.xml");
		StudentService StudentService = (StudentService) ctx
				.getBean("StudnetService");
		String grade = new String(request.getParameter("grade").getBytes(
				"iso-8859-1"), "UTF-8");
		String the_class = new String(request.getParameter("the_class")
				.getBytes("iso-8859-1"), "UTF-8");
		String name_tos = new String(request.getParameter("name").getBytes(
				"iso-8859-1"), "UTF-8");
		String Data = StudentService.search_Students_count(grade, the_class,
				name_tos);
		out.print(Data);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
