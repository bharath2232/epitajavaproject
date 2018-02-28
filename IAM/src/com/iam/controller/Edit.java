/**  
* Edit.java - A controller class to handle "/Edit" url which is coming from jsp
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

@WebServlet(name = "Edit", urlPatterns = { "/Edit" })
public class Edit extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method is use to server 'post' request for /Edit url pattern. It takes
	 * updated student data from jsp form, put into student POJO object and then
	 * update the data to database. once update operation is performed, it redirect
	 * to View controller.
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

		int rollno = Integer.parseInt(request.getParameter("rollno"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String DOB = request.getParameter("data_of_birth");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact_no");

		Student stud = new Student(rollno, fname, lname, email, gender, DOB, address, contact);
		StudentDao studDao = new StudentDaoIml();
		int status = studDao.update(stud);
		response.sendRedirect("View");
	}

	/**
	 * This method is use to server 'get' request for /Edit url pattern. It takes
	 * updated student data from jsp form, put into student POJO object and then
	 * update the data to database. once update operation is performed, it redirect
	 * to View controller.
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
