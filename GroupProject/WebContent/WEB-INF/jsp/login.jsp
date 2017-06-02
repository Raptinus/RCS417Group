<html>
	<head>
		<%@ include file = "include/header.jsp" %>
	</head>	
	<body>
		<%@ include file = "include/menu.jsp" %>
		<p/>
		${errormsg}
		<p/>
	<form action='login' method='post'>
		User Name: <input type = 'text' name = 'id' value = '' /><br/>
		Password: <input type = 'password' name = 'pwd' value = '' /><br/>
		<input type='submit' value = 'Login'/>
	</form>
	</body>
</html>