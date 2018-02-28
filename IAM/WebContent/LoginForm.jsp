
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body bgcolor=#DDDDDD>
	<p></p>


	<br />
	<center>
		<form action="Login" method="post">
			<table>
				<tr>
					<td>User:</td>
					<td><input type="text" name="user" required /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Login" /></td>
				</tr>
			</table>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>

</body>
</html>

