/**  
* Logout.java - A controller class to handle "/Logout" url which is coming from jsp
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/
package com.iam.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Logout", urlPatterns = { "/Logout" })
public class Logout extends HttpServlet {

	/**
	 * This method is use to server 'post' request from of /Logout url pattern. it
	 * invalidate the session and redirect to LoginForm.jsp page.
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

		out.println("<br/><br/><br/><center><h3>Admin Logout Success</h3></center>");
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("LoginForm.jsp").include(request, response);

	}

	/**
	 * This method is use to server 'get' request from of /Logout url pattern. it
	 * invalidate the session and redirect to LoginForm.jsp page.
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
