/**  
* Delete.java - A controller class to handle "/Delete" url which is coming from jsp
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/

package com.iam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iam.dao.StudentDao;
import com.iam.dao.impl.StudentDaoIml;

@WebServlet(name = "Delete", urlPatterns = { "/Delete" })

public class Delete extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method is use to server 'post' request for /Delete url pattern. It takes
	 * student rollno from jsp form, delete the data from database. once deletion
	 * operation is performed, its redirect to View controller.
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
		String srollno = request.getParameter("rollno");
		int rollno = Integer.parseInt(srollno);
		StudentDao studDao = new StudentDaoIml();
		studDao.delete(rollno);
		response.sendRedirect("View");
	}

	/**
	 * This method is use to server 'get' request for /Delete url pattern. It takes
	 * student rollno from jsp form, delete the data from database. once deletion
	 * operation is performed, its redirect to View controller.
	 * 
	 * @param request,
	 *            response
	 * @return
	 * @throws ServletException,
	 *             IOException
	 * 
	 * 
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
