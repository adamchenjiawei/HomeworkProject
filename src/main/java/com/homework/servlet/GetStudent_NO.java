package com.homework.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.homework.model.Student;
import com.homework.model.User;
import com.homework.service.StudentService;

/**
 * Servlet implementation class GetStudent_NO
 */
public class GetStudent_NO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStudent_NO() {
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
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String homeWorkName_NO = request.getParameter("homeWorkName_NO");
		homeWorkName_NO = new String(homeWorkName_NO.getBytes("iso-8859-1"), "UTF-8");
		String className_NO = request.getParameter("className_NO");
		className_NO = new String(className_NO.getBytes("iso-8859-1"), "UTF-8");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/homework/properties/spring-context.xml");
		StudentService studentService = (StudentService) ctx.getBean("StudentService");
		List<Student> student = studentService.getStudentNO(homeWorkName_NO, className_NO, user.getAccount());
		try {
			out.println(JSONArray.fromObject(student).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
