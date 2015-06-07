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
 * Servlet implementation class Get_Search_TeaCher_Count
 */
public class Get_Search_TeaCher_Count extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Get_Search_TeaCher_Count() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request == null) {
			return;
		}
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name_tos = new String(request.getParameter("name").getBytes(
				"iso-8859-1"), "UTF-8");
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext(
				"com/homework/properties/spring-context.xml");
		TeacherService TeaCherService = (TeacherService) ctx
				.getBean("TeacherService");
		String Data = TeaCherService.search_teacher_count(name_tos);
		out.print(Data);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
