<!DOCTYPE html>
<html>
<head>
<title>AddForm</title>
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



	<%
		if (session.getAttribute("status") == null) {
		} else {
			int status = (Integer) session.getAttribute("status");
			if (status == 0)
				out.println("<center><h3>Records not added successfully</h3></center>");
			else {

				out.println("<center><h3>Records added successfully</h3></center>");
			}
			session.setAttribute("status", null);
		}
	%>

	<%@ include file="Header.jsp"%>

	<div style="text-align: center">
		<form action="Add" method="post">
			<h2>Add Data</h2>
			<table  cellpadding='4px' cellspacing='2px'
				align='center' width='600px'>
				<tr>
					<td>First Name</td>
					<td>:</td>
					<td><input type="text" name="fname" maxlength="100" required></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td>:</td>
					<td><input type="text" name="lname" maxlength="100"></td>
				</tr>
				<tr>
					<td>E-Mail ID</td>
					<td>:</td>
					<td><input type="email" name="email" maxlength="100" required></td>
				</tr>

				<tr>
					<td>Gender</td>
					<td>:</td>
					<td><input type="radio" name="gender" value="male" checked="checked">
						Male <input type="radio" name="gender" value="female">Female
					</td>
				</tr>
				<tr>
					<td>Date Of Birth<br> <font size="1" color="#ff0000">(MM/DD/YYYY)</font></td>
					<td>:</td>
					<td><input name="data_of_birth" maxlength="10" type="date" required>
						<br></td>
				</tr>
				<tr>
					<td>Permanent Address</td>
					<td>:</td>
					<td><textarea name="address" rows="2" cols="20" required></textarea></td>
				</tr>
				<tr>
					<td>Contact No<br> (Eg:1234567890)
					</td>
					<td>:</td>
					<td><input name="contact_no" maxlength="15" type="text" required></td>
				</tr>



				<tr>
					<td colspan="3" height="30">
						<div align="center">
							&nbsp; <input type='Submit' name='Submit' value='Register' />
						</div>
					</td>
				</tr>
			</table>

		</form>
	</div>
	<%@ include file="Footer.jsp"%>



</body>
</html>

