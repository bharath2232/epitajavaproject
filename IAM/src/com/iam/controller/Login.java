/**  
* Login.java - A controller class to handle "/Login" url which is coming from jsp
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/
package com.iam.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iam.dao.AdminDao;
import com.iam.dao.impl.AdminDaoIml;

@WebServlet(name = "Login", urlPatterns = { "/Login" })

public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method is use to server 'post' request for /Login url pattern. It takes
	 * user name and password from jsp page and check that user is in DB or not. If
	 * the valid user is login the contoller will redirect to adminhome.jsp else it
	 * will redirect to LoginForm.jsp
	 * 
	 * @param request,
	 *            response
	 * @return
	 * @throws ServletException,
	 *             IOException
	 * 
	 * 
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String user = request.getParameter("user");
		String password = request.getParameter("password");

		AdminDao admin = new AdminDaoIml();
		boolean status = admin.checkAdmin(user, password);
		HttpSession session = request.getSession();
		if (status) {
			session.setAttribute("admin", "true");
			request.getRequestDispatcher("adminhome.jsp").include(request, response);
		} else {

			session.setAttribute("Error", "Sorry, user name or password is Wrong!");
			out.println(password);
			out.println("Sorry, user name or password is Wrong!");
			request.getRequestDispatcher("LoginForm.jsp").include(request, response);
		}

	}

	/**
	 * This method is use to server 'get' request for /Login url pattern. It takes
	 * user name and password from jsp page and check that user is in DB or not. If
	 * the valid user is login the contoller will redirect to adminhome.jsp else it
	 * will redirect to LoginForm.jsp
	 * 
	 * @param request,
	 *            response
	 * @return
	 * @throws ServletException,
	 *             IOException
	 * 
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
