<html>
	<head>
		<%@ include file = "include/header.jsp" %>
	</head>	
	<body>
		<%@ include file = "include/menu.jsp" %>

	${errmsg} <p />
	<form action='login' method='post'>
		User Name: <input type = 'text' name = 'id' value = '' pattern = "[a-zA-Z0-9]+" required/><br/>
		Password: <input type = 'password' name = 'pwd' value = '' pattern = "[a-zA-Z0-9]+" required/><br/>
		<input type='submit' value = 'Login'/>
	</form>
	</body>
</html>