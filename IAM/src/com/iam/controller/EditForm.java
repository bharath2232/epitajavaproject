/**  
* EditForm.java - A controller class to handle "/EditForm" url which is coming from jsp
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

import com.iam.entity.Student;
import com.iam.dao.StudentDao;
import com.iam.dao.impl.StudentDaoIml;

@WebServlet(name = "EditForm", urlPatterns = { "/EditForm" })
public class EditForm extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method is use to server 'post' request for /EditForm url pattern. It
	 * takes student roll no from jsp form. Get the student data , store into
	 * student pojo object and the load into EditForm.jsp
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
		PrintWriter out = response.getWriter();
		String srollno = request.getParameter("rollno");
		int rollno = Integer.parseInt(srollno);

		StudentDao studDao = new StudentDaoIml();

		Student bean = studDao.getStudentDataByRollno(rollno);
		request.setAttribute("Student", bean);
		request.getRequestDispatcher("EditForm.jsp").include(request, response);
	}

	/**
	 * This method is use to server 'get' request for /EditForm url pattern. It
	 * takes student roll no from jsp form. Get the student data , store into
	 * student pojo object and the load into EditForm.jsp
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
