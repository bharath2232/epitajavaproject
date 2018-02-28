/**  
* View.java - A controller class to handle "/View" url which is coming from jsp
* @author  Bharat and Atiqullah
* @version 1.0 
* @see College Project
*/
package com.iam.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iam.entity.Student;
import com.iam.dao.StudentDao;
import com.iam.dao.impl.StudentDaoIml;

@WebServlet(name = "View", urlPatterns = { "/View" })
public class View extends HttpServlet {

	/**
	 * This method is use to server 'post' request from of /View url pattern. it
	 * will take get all student data from database and show to ViewForm.jsp in a
	 * tabular format.
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
		StudentDao studDao = new StudentDaoIml();
		List<Student> list = studDao.getAllStudentData();
		request.setAttribute("list", list);
		request.getRequestDispatcher("ViewForm.jsp").include(request, response);

	}

	/**
	 * This method is use to server 'get' request from of /View url pattern. it will
	 * take get all student data from database and show to ViewForm.jsp in a tabular
	 * format.
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
