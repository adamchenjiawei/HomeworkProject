package com.homework.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.homework.model.User;
import com.homework.service.LoginService;

/**
 * Servlet implementation class Login
 */
@Service("/index")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// super.service(arg0, arg1);
		if (request == null) {
			return;
		}
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String login_user = request.getParameter("login_user");
		String user_type = request.getParameter("user_type");
		String login_password = request.getParameter("password");
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext(
				"com/homework/properties/spring-context.xml");
		LoginService LoginService = (LoginService) ctx.getBean("LoginService");
		User user = LoginService.login(user_type, login_user, login_password);
		if (user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			// 使用req对象获取RequestDispatcher对象
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			// 使用RequestDispatcher对象在服务器端向目的路径跳转
			dispatcher.forward(request, response);
		} else {
			// 使用req对象获取RequestDispatcher对象
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		out.flush();
		out.close();

	}
}
