<html>
	<head>
		<%@ include file = "include/header.jsp" %>
	</head>	
	<body>
		<%@ include file = "include/menu.jsp" %>
		
		
		
		<form id = "editpost" action = "newpost" method="post">
		
		<input type="hidden" name="creatorid" value="<%=loginUser.getUserId()%>">
				<p />
		
		
		
		Title:<br />
		<input type="text" name="title" value="">
		
		<p />
		Short Description:<br />
		<input type="text" name="shortdesc" value="">		
		<p />
		
		Detailed Description:<br />
		<textarea rows="10" cols="45" name="longdesc"></textarea>
		<p />
		<input type="submit" value="Submit">

		</form>		
			
			
	</body>
</html>
		