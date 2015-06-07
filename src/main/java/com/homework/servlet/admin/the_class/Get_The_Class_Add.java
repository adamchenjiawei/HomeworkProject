package com.homework.servlet.admin.the_class;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homework.service.TheClassService;

/**
 * Servlet implementation class Get_The_Class_Add
 */
public class Get_The_Class_Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Get_The_Class_Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request == null) {
			return;
		}
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String grade = request.getParameter("grade");
		String the_class_info = request.getParameter("the_class_info");
		String counselors = request.getParameter("counselors");
		String e_mail = request.getParameter("e_mail");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext(
				"com/homework/properties/spring-context.xml");
		TheClassService TheClassService = (TheClassService) ctx
				.getBean("TheClassService");
		TheClassService.add_teacher
		(grade, the_class_info, counselors, age, sex, e_mail, phone);
		response.sendRedirect("Admin/Home.jsp");
		out.flush();
		out.close();
	}

}
