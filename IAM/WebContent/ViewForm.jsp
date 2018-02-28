<%@ page import="java.util.ArrayList"%>
<%@ page import="com.iam.entity.Student"%>
<!DOCTYPE html>
<html>
<head>
<title>Report</title>
</head>
<body>


	<%
		String name = (String) session.getAttribute("admin");
		if (session == null || name == null) {
			session.setAttribute("Error", "Not Admin!");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginForm.jsp");
			rd.forward(request, response);
		}
	%>
	<%@ include file="Header.jsp"%>

	<div style="text-align: center">
		<h1>View Data</h1>

		<%
			ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("list");

			out.println("<table border='1' cellpadding='12px' cellspacing='2px' align='center'>");
			out.print(
					"<tr><th>Rollno</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Gender</th><th>DOB</th><th> address</th><th>contact</th><th>Edit</th><th>Delete</th>");
			for (Student stud : list) {
				out.print("<tr><td>" + stud.getRollno() + "</td><td>" + stud.getFname() + "</td><td>" + stud.getLname()
						+ "</td><td>" + stud.getEmail() + "</td><td>" + stud.getGender()+ "</td><td>" + stud.getDOB() + "</td><td>"
						+ stud.getAddress() + "</td><td>" + stud.getContact() + "</td><td><a href='EditForm?rollno="
						+ stud.getRollno() + "'>Edit</a></td><td><a href='Delete?rollno=" + stud.getRollno()
						+ "'>Delete</a></td></tr>");
			}
			out.println("</table>");
		%>
	</div>
	<%@ include file="Footer.jsp"%>


</body>
</html>

