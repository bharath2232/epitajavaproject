<%@ page import="com.iam.entity.Student"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit</title>
</head>
<body>


	<%
		String name = (String) session.getAttribute("admin");
		//out.println(name);
		if (session == null || name == null) {
			session.setAttribute("Error", "Not Admin!");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginForm.jsp");
			rd.forward(request, response);
		}
	%>
	<%@ include file="Header.jsp"%>

	<div style="text-align: center">
		<h1>Edit Form</h1>
		<%
			Student stud = (Student) request.getAttribute("Student");
			out.print("<form action='Edit' method='post'>");
			out.print("<table  cellpadding='4px' cellspacing='2px' align='center' width='600px'> ");
			out.print("<tr><td><input type='hidden' name='rollno' value='" + stud.getRollno() + "'/></td></tr>");
			out.print("<tr><td>First Name:</td><td><input type='text' required name='fname' value='" + stud.getFname()
					+ "'/></td></tr>");
			out.print("<tr><td>Last Name:</td><td><input type='text' name='lname' value='" + stud.getLname()
					+ "'/></td></tr>");

			out.print("<tr><td>Email:</td><td><input type='email' name='email' required value='" + stud.getEmail()
					+ "'/></td></tr>");
			if (stud.getGender().equals("male"))

				out.print("<tr><td>Gender:</td><td><input type='radio' checked='checked' name='gender' value='male'> Male <input type='radio' name='gender' value='female'>Female </td></tr>");
			
			else
				out.print("<tr><td>Gender:</td><td><input type='radio'  name='gender' value='male'> Male <input type='radio' checked='checked' name='gender' value='female'>Female </td></tr>");
			
			
			out.print("<tr><td>DOB:</td><td><input type='text' name='data_of_birth' required value='" + stud.getDOB()
					+ "'/></td></tr>");

			out.print("<tr><td>Address:</td><td><textarea name='address' required style='width:160px;height:80px;'>"
					+ stud.getAddress() + "</textarea></td></tr>");

			out.print("<tr><td>Contact No:</td><td><input type='text' name='contact_no' required value='" + stud.getContact()
					+ "'/></td></tr>");

			out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update Student'/></td></tr>");
			out.print("</table>");
			out.print("</form>");
		%>
	</div>
	<%@ include file="Footer.jsp"%>


</body>
</html>

