/**  
* Add.java - A controller class to handle "/Add" url which is coming from jsp
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
import javax.servlet.http.HttpSession;

import com.iam.entity.Student;
import com.iam.dao.StudentDao;
import com.iam.dao.impl.StudentDaoIml;

@WebServlet(name = "Add", urlPatterns = { "/Add" })
public class Add extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * This method is use to server 'post' request for /ADD url pattern. It takes
	 * student data from jsp form, put into student POJO object and then save the
	 * data to database. once insertion operation is performed it send status of
	 * operation and redirect to AddForm.jsp page.
	 * 
	 * @param request,
	 *            response
	 * @return
	 * @throws ServletException
	 *             IOException
	 * 
	 * 
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String DOB = request.getParameter("data_of_birth");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact_no");

		Student stud = new Student(fname, lname, email, gender, DOB, address, contact);

		StudentDao studDao = new StudentDaoIml();
		int status = studDao.save(stud);
		HttpSession session = request.getSession();
		session.setAttribute("status", status);
		request.getRequestDispatcher("AddForm.jsp").include(request, response);

	}

	/**
	 * This method is use to server 'get' request for /ADD url pattern. It takes
	 * student data from jsp form, put into student POJO object and then save the
	 * data to database. once insertion operation is performed it send status of
	 * operation and redirect to AddForm.jsp page.
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
